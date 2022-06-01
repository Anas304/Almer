package com.example.almer.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFF7F7F7F)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


// Custom colors form figma

val darkgrey = Color(0xFF7F7F7F)
val Colors.darkgrey: Color
    @Composable
    get() = darkgrey

//
val lightGreen200 = Color(0x9932CD32)
/** Extenssion function for Custom Color */
val Colors.lightGreen: Color
    @Composable
    get() = lightGreen200

// another Extenssion function for custom colors
val lightRed200 = Color(0xFFE66E66)
val Colors.lightRed: Color
    @Composable
    get() = lightRed200