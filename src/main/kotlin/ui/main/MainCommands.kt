package com.jjoon.ui.main

import com.jjoon.ui.MainWindow

class MainCommands(
    private val textArea: MainTextArea,
    private val mainWindow: MainWindow
){

    fun commandinput(
        input: String,
    ) {
        when (input.trim()) {
            "exit" -> {
                textArea.append("Exiting...\n")
                mainWindow.dispose() // JFrame 종료
            }
            "" -> textArea.append("")
            else -> textArea.append("\"${input.trim()}\"is unknown command.\n")
        }
    }
}