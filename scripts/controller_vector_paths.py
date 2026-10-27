#!/usr/bin/env python3
"""Normalize SVG arc flags for Android VectorDrawable, and validate every icon.

SVG permits adjacent one-character arc flags (00/01/10/11). Android's
PathParser treats those as one float, so every argument must be separated.
No coordinates, commands, glyph IDs or visual styles are changed.
"""
import argparse
from pathlib import Path
import re
import xml.etree.ElementTree as ET

ROOT = Path(__file__).resolve().parents[1]
DRAWABLES = ROOT / 'FCL/src/main/res/drawable'
NUMBER = re.compile(r'[+-]?(?:\d+\.?\d*|\.\d+)(?:[eE][+-]?\d+)?')
ARITY = dict(M=2, L=2, H=1, V=1, C=6, S=4, Q=4, T=2, A=7)
PATH_DATA = re.compile(r'(android:pathData=")([^"]+)(")')
ANDROID_PATH = '{http://schemas.android.com/apk/res/android}pathData'


def normalize(path):
    """Parse SVG grammar, consuming arc flags as single characters."""
    pos = 0
    command = None
    output = []
    while pos < len(path):
        while pos < len(path) and path[pos] in ' ,\t\r\n':
            pos += 1
        if pos == len(path):
            break
        if path[pos].isalpha():
            command = path[pos]
            pos += 1
            if command.upper() == 'Z':
                output.append(command)
                command = None
                continue
            if command.upper() not in ARITY:
                raise ValueError('Unknown command: ' + command)
        if command is None:
            raise ValueError('Coordinates without command')
        values = []
        for index in range(ARITY[command.upper()]):
            while pos < len(path) and path[pos] in ' ,\t\r\n':
                pos += 1
            if command.upper() == 'A' and index in (3, 4):
                if pos == len(path) or path[pos] not in '01':
                    raise ValueError('Invalid SVG arc flag')
                values.append(path[pos])
                pos += 1
            else:
                match = NUMBER.match(path, pos)
                if not match:
                    raise ValueError('Missing argument at ' + str(pos))
                values.append(match.group())
                pos = match.end()
        output.append(command + ' ' + ' '.join(values))
        if command == 'M':
            command = 'L'
        elif command == 'm':
            command = 'l'
    return ' '.join(output)


def validate_android(path):
    """Validate with Android's float-token semantics, not SVG flag semantics."""
    segments = re.findall(r'([MmLlHhVvCcSsQqTtAaZz])([^MmLlHhVvCcSsQqTtAaZz]*)', path)
    if not segments or path[0] not in 'Mm':
        raise ValueError('Path must start with moveto')
    for command, arguments in segments:
        tokens = NUMBER.findall(arguments)
        if NUMBER.sub('', arguments).strip(' ,\t\r\n'):
            raise ValueError('Invalid path token')
        if command.upper() == 'Z':
            if tokens:
                raise ValueError('Close command with arguments')
            continue
        count = ARITY[command.upper()]
        if not tokens or len(tokens) % count:
            raise ValueError(f'{command}: {len(tokens)} floats, expected multiple of {count}')
        if command.upper() == 'A':
            for offset in range(0, len(tokens), 7):
                if tokens[offset + 3] not in ('0', '1') or tokens[offset + 4] not in ('0', '1'):
                    raise ValueError('Android arc flags must be separate 0/1 tokens')


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--fix', action='store_true')
    args = parser.parse_args()
    changed = []
    paths = 0
    files = sorted(DRAWABLES.glob('controller_icon_*.xml'))
    if len(files) != 68:
        raise ValueError(f'Expected 68 controller resources, found {len(files)}')
    for file in files:
        text = file.read_text()
        if args.fix:
            updated = PATH_DATA.sub(lambda m: m[1] + (normalize(m[2]) if re.search('[Aa]', m[2]) else m[2]) + m[3], text)
            if updated != text:
                file.write_text(updated)
                changed.append(file.name)
        for element in ET.parse(file).getroot().iter():
            path = element.get(ANDROID_PATH)
            if path:
                try:
                    validate_android(path)
                except ValueError as error:
                    raise ValueError(f'{file.name}: {error}') from error
                paths += 1
    print(f'Validated {len(files)} controller drawables / {paths} paths; normalized {len(changed)} files.')


if __name__ == '__main__':
    main()
