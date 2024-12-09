package com.jjoon.ui.main.commands

import com.jjoon.ui.MainWindow
import com.jjoon.ui.main.MainTextArea
import com.jjoon.util.ConfigLoader
import com.jjoon.util.LangLoader

class MainCommands(
    private val textArea: MainTextArea,
    private val mainWindow: MainWindow
) {
    private val configLoader = ConfigLoader()
    private var language = LangLoader(configLoader.getProperty("language"))


    fun reloadlang(){
        language = LangLoader(configLoader.getProperty("language"))
    }

    fun commandinput(
        input: String,
    ) {

        val inputlist = input.trim().split(' ')
        when (inputlist[0]) {
            //종료 명령어
            "exit", "bye" -> {
                textArea.append("Exiting...\n")
                mainWindow.dispose()
            }

            //전체 삭제
            "clear", "cls" -> {
                textArea.text = ""
            }

            "lang" -> {

            }

            //도움!!!!!!!!!!!!!!!!!
            "help" -> {
                textArea.append(
                    """
                    Available commands:
                    - exit, bye: Exit the program
                    - clear: Clear the text area
                    - help: Display this help message
                    """
                )
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