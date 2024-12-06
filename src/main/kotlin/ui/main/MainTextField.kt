package com.jjoon.ui.main

import com.jjoon.ui.MainWindow
import com.jjoon.util.ConfigPull
import java.awt.Insets
import java.awt.event.ActionEvent
import javax.swing.BorderFactory
import javax.swing.JTextField

class MainTextField(
    textArea: MainTextArea,
    mainWindow: MainWindow
): JTextField(){
    init{
        val configcolor = ConfigPull()

        background = configcolor.bgcolor()
        foreground = configcolor.textcolor()
        border = BorderFactory.createLineBorder(configcolor.textcolor(), 2)
        margin = Insets(30, 5, 30, 5)

        //커맨드 설정
        val command = MainCommands(textArea, mainWindow)
        addActionListener { _: ActionEvent ->
            val input = text
            textArea.append(">>> $input\n")

            text = ""
            //커맨드  확인
            command.commandinput(input)
        }
    }

}