"""Regression cases for the Android 14 icon inflation crash in 1.3.4.4."""
import sys
from pathlib import Path
import unittest

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
from controller_vector_paths import normalize, validate_android


class ControllerVectorPathsTest(unittest.TestCase):
    def test_reported_sword_path_is_rejected_before_fix(self):
        with self.assertRaises(ValueError):
            validate_android('M9.5 17.5 20.414 6.586A2 2 0 0021 5.172V3h-2.172a2 2 0 00-1.414.586L6.5 14.5')

    def test_reported_sword_preserves_coordinates_and_separates_flags(self):
        fixed = normalize('M9.5 17.5 20.414 6.586A2 2 0 0021 5.172V3h-2.172a2 2 0 00-1.414.586L6.5 14.5')
        self.assertEqual('M 9.5 17.5 L 20.414 6.586 A 2 2 0 0 0 21 5.172 V 3 h -2.172 a 2 2 0 0 0 -1.414 .586 L 6.5 14.5', fixed)
        validate_android(fixed)

    def test_all_flag_combinations_and_adjacent_positive_coordinate(self):
        for flags in ('00', '01', '10', '11'):
            fixed = normalize('M0 0A2 3 0 ' + flags + '21 5')
            self.assertEqual('M 0 0 A 2 3 0 ' + flags[0] + ' ' + flags[1] + ' 21 5', fixed)
            validate_android(fixed)

    def test_repeated_relative_arcs_signed_decimals_and_exponents(self):
        fixed = normalize('M0 0a2 2 0 01-.5.6 3 4 0 10 1e-3-2Z')
        validate_android(fixed)
        self.assertEqual(fixed, normalize(fixed))

    def test_invalid_flags_or_incomplete_arc_are_rejected(self):
        for path in ('M0 0A2 2 0 2 0 1 2', 'M0 0A2 2 0 0 0 1'):
            with self.assertRaises(ValueError):
                normalize(path)

    def test_close_and_implicit_lineto(self):
        self.assertEqual('m 1 2 l 3 4 z', normalize('m1 2 3 4z'))
        validate_android(normalize('m1 2 3 4z'))


if __name__ == '__main__':
    unittest.main()
