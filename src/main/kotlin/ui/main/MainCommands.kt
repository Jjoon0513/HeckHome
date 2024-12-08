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
            //종료 명령어
            "exit", "bye" -> {
                textArea.append("Exiting...\n")
                mainWindow.dispose()
            }

            //전체 삭제
            "clear" -> {
                textArea.text = ""
            }

            //도움!!!!!!!!!!!!!!!!!
            "help" -> {
                textArea.append("Available commands:\n")
                textArea.append("- exit, bye: Exit the program\n")
                textArea.append("- clear: Clear the text area\n")
                textArea.append("- help: Display this help message\n")
            }

            //아무것도 입력하지 않았을때
            "" -> {
                textArea.append("")
            }

            //명령어가 아닐때
            else -> {
                textArea.append("\"${input.trim()}\"is unknown command.\n")
            }
        }
    }
}