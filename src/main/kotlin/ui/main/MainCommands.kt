package com.jjoon.ui.main

import com.jjoon.ui.MainWindow

class MainCommands(
    private val textArea: MainTextArea,
    private val mainWindow: MainWindow
) {

    fun commandinput(
        input: String,
    ) {
        when (input.trim()) {
            "exit", "bye" -> {
                textArea.append("Exiting...\n")
                mainWindow.dispose() // JFrame 종료
            }

            "clear" -> textArea.text = ""
            "help" -> {
                textArea.append("Available commands:\n")
                textArea.append("- exit, bye: Exit the program\n")
                textArea.append("- clear: Clear the text area\n")
                textArea.append("- help: Display this help message\n")
            }

            "" -> textArea.append("")
            else -> textArea.append("\"${input.trim()}\"is unknown command.\n")
        }
    }
}