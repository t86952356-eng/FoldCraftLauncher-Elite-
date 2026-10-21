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
    )

    fun find(id: String?): Icon = icons.firstOrNull { it.id == id } ?: icons.first()
}
