package com.tungsten.fcl.control

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.tungsten.fcl.R

/** Stable icon IDs are serialized with controller files so shared layouts keep their icons. */
object ControllerIconRegistry {
    const val NONE = "none"

    data class Icon(val id: String, @StringRes val labelRes: Int, @DrawableRes val drawableRes: Int)

    val icons: List<Icon> = listOf(
        Icon("none", R.string.controller_icon_none, R.drawable.controller_icon_none),
        Icon("pickaxe", R.string.controller_icon_pickaxe, R.drawable.controller_icon_pickaxe),
        Icon("eye", R.string.controller_icon_eye, R.drawable.controller_icon_eye),
        Icon("axe", R.string.controller_icon_axe, R.drawable.controller_icon_axe),
        Icon("sword", R.string.controller_icon_sword, R.drawable.controller_icon_sword),
        Icon("run", R.string.controller_icon_run, R.drawable.controller_icon_run),
        Icon("stand", R.string.controller_icon_stand, R.drawable.controller_icon_stand),
        Icon("boost", R.string.controller_icon_boost, R.drawable.controller_icon_boost),
        Icon("camera", R.string.controller_icon_camera, R.drawable.controller_icon_camera),
        Icon("keyboard", R.string.controller_icon_keyboard, R.drawable.controller_icon_keyboard),
        Icon("mouse", R.string.controller_icon_mouse, R.drawable.controller_icon_mouse),
        Icon("lightning", R.string.controller_icon_lightning, R.drawable.controller_icon_lightning),
        Icon("ghost", R.string.controller_icon_ghost, R.drawable.controller_icon_ghost),
        Icon("cube", R.string.controller_icon_cube, R.drawable.controller_icon_cube),
        Icon("x_mark", R.string.controller_icon_x_mark, R.drawable.controller_icon_x_mark),
        Icon("bow", R.string.controller_icon_bow, R.drawable.controller_icon_bow),
        Icon("arrow", R.string.controller_icon_arrow, R.drawable.controller_icon_arrow),
        Icon("bag", R.string.controller_icon_bag, R.drawable.controller_icon_bag),
        Icon("arrow_up", R.string.controller_icon_arrow_up, R.drawable.controller_icon_arrow_up),
        Icon("arrow_down", R.string.controller_icon_arrow_down, R.drawable.controller_icon_arrow_down),
        Icon("copy", R.string.controller_icon_copy, R.drawable.controller_icon_copy),
        Icon("paste", R.string.controller_icon_paste, R.drawable.controller_icon_paste),
        Icon("chat", R.string.controller_icon_chat, R.drawable.controller_icon_chat),
        Icon("screen", R.string.controller_icon_screen, R.drawable.controller_icon_screen),
        Icon("pencil", R.string.controller_icon_pencil, R.drawable.controller_icon_pencil),
        Icon("star", R.string.controller_icon_star, R.drawable.controller_icon_star),
        Icon("wifi", R.string.controller_icon_wifi, R.drawable.controller_icon_wifi),
        Icon("bluetooth", R.string.controller_icon_bluetooth, R.drawable.controller_icon_bluetooth),
        Icon("moon", R.string.controller_icon_moon, R.drawable.controller_icon_moon),
        Icon("beetle", R.string.controller_icon_beetle, R.drawable.controller_icon_beetle),
        Icon("capacitor", R.string.controller_icon_capacitor, R.drawable.controller_icon_capacitor),
        Icon("minecraft_sword", R.string.controller_icon_minecraft_sword, R.drawable.controller_icon_minecraft_sword),
        Icon("minecraft_axe", R.string.controller_icon_minecraft_axe, R.drawable.controller_icon_minecraft_axe),
        Icon("minecraft_pickaxe", R.string.controller_icon_minecraft_pickaxe, R.drawable.controller_icon_minecraft_pickaxe),
        Icon("globe", R.string.controller_icon_globe, R.drawable.controller_icon_globe),
        Icon("gear", R.string.controller_icon_gear, R.drawable.controller_icon_gear),
        Icon("motion_wave", R.string.controller_icon_motion_wave, R.drawable.controller_icon_motion_wave),
        Icon("recycle", R.string.controller_icon_recycle, R.drawable.controller_icon_recycle),
        Icon("shield", R.string.controller_icon_shield, R.drawable.controller_icon_shield),
        Icon("heart", R.string.controller_icon_heart, R.drawable.controller_icon_heart),
        Icon("torch", R.string.controller_icon_torch, R.drawable.controller_icon_torch),
        Icon("potion", R.string.controller_icon_potion, R.drawable.controller_icon_potion),
        Icon("helmet", R.string.controller_icon_helmet, R.drawable.controller_icon_helmet),
        Icon("chest", R.string.controller_icon_chest, R.drawable.controller_icon_chest),
        Icon("shovel", R.string.controller_icon_shovel, R.drawable.controller_icon_shovel),
        Icon("fishing_rod", R.string.controller_icon_fishing_rod, R.drawable.controller_icon_fishing_rod),
        Icon("compass", R.string.controller_icon_compass, R.drawable.controller_icon_compass),
        Icon("map", R.string.controller_icon_map, R.drawable.controller_icon_map),
        Icon("target", R.string.controller_icon_target, R.drawable.controller_icon_target),
        Icon("lock", R.string.controller_icon_lock, R.drawable.controller_icon_lock),
        Icon("unlock", R.string.controller_icon_unlock, R.drawable.controller_icon_unlock),
        Icon("volume", R.string.controller_icon_volume, R.drawable.controller_icon_volume),
        Icon("pause", R.string.controller_icon_pause, R.drawable.controller_icon_pause),
        Icon("gamepad", R.string.controller_icon_gamepad, R.drawable.controller_icon_gamepad),
        Icon("crosshair", R.string.controller_icon_crosshair, R.drawable.controller_icon_crosshair),
        Icon("hand", R.string.controller_icon_hand, R.drawable.controller_icon_hand),
        Icon("rocket", R.string.controller_icon_rocket, R.drawable.controller_icon_rocket),
        Icon("gem", R.string.controller_icon_gem, R.drawable.controller_icon_gem),
        Icon("key", R.string.controller_icon_key, R.drawable.controller_icon_key),
        Icon("door", R.string.controller_icon_door, R.drawable.controller_icon_door),
        Icon("sun", R.string.controller_icon_sun, R.drawable.controller_icon_sun),
        Icon("clock", R.string.controller_icon_clock, R.drawable.controller_icon_clock),
        Icon("download", R.string.controller_icon_download, R.drawable.controller_icon_download),
        Icon("upload", R.string.controller_icon_upload, R.drawable.controller_icon_upload),
        Icon("play", R.string.controller_icon_play, R.drawable.controller_icon_play),
        Icon("headphones", R.string.controller_icon_headphones, R.drawable.controller_icon_headphones),
        Icon("battery", R.string.controller_icon_battery, R.drawable.controller_icon_battery),
        Icon("move", R.string.controller_icon_move, R.drawable.controller_icon_move),
    )

    fun find(id: String?): Icon = icons.firstOrNull { it.id == id } ?: icons.first()
}
