package com.jjoon.util

import java.awt.Color

class ConfigPull {
    private val config = ConfigLoader()

    private val bgcolor = config.getProperty("BackgroundColor") ?: "000000"
    private val textcolor = config.getProperty("TextColor") ?: "FFFFFF"


    fun bgcolor(): Color {return Color(bgcolor.toInt(16))}

    fun textcolor(): Color {return Color(textcolor.toInt(16))}

    fun maintitle(): String {return config.getProperty("MainTitle") ?: "ERROR"}
}