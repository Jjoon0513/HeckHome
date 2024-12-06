package com.jjoon.ui.main

import com.jjoon.util.ConfigPull
import javax.swing.JTextArea
import javax.swing.BorderFactory

class MainTextArea : JTextArea() {

    init {
        val configcolor = ConfigPull()

        isEditable = false

        // 16진수로 색상 변환
        background = configcolor.bgcolor()
        foreground = configcolor.textcolor()
        border = BorderFactory.createLineBorder(configcolor.textcolor(), 2)

        lineWrap = true
        wrapStyleWord = true
    }
}
