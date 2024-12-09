package com.jjoon.ui.main

import com.jjoon.util.ConfigPull
import java.awt.Font
import javax.swing.JTextArea
import javax.swing.BorderFactory

class MainTextArea : JTextArea() {

    init {
        val configcolor = ConfigPull()

        isEditable = false
        font = Font("Noto Sans", Font.PLAIN, 12)
        background = configcolor.bgcolor()
        foreground = configcolor.textcolor()
        border = BorderFactory.createLineBorder(configcolor.textcolor(), 2)
        lineWrap = true
        wrapStyleWord = true
    }

    fun changefontsize(size: Int) {
        font = Font("Noto Sans", Font.PLAIN, size)
    }
}
