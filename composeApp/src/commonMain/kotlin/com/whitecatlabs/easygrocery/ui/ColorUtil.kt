package com.whitecatlabs.easygrocery.ui

import androidx.compose.ui.graphics.Color

object ColorUtil {
    fun String.parseColor(): Color {
        var color = trim().removePrefix("#")
        if (color.length == 3) {
            color = color.map { "$it$it" }.joinToString("")
        }
        if (color.length == 4) {
            color = color.map { "$it$it" }.joinToString("")
        }
        if (color.length == 6) {
            color = "FF$color"
        }

        return try {
            Color(color.toLong(16))
        } catch (e: Exception) {
            Color.Black
        }
    }
}