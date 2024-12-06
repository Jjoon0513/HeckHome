package com.jjoon.ui.main

import com.jjoon.ui.main.titlebar.MainTitleBarButton
import com.jjoon.util.ConfigPull
import javax.swing.*
import java.awt.*
import java.awt.event.*

class MainTitleBar(private val mainWindow: JFrame) : JPanel(BorderLayout()) {
    private var xOffset = 0
    private var yOffset = 0
    private val configPull = ConfigPull()

    init {
        border = BorderFactory.createLineBorder(configPull.textcolor(), 2)
        background = configPull.bgcolor()

        //TODO - 타이틀 텍스트도 위치를 바꿔야 할듯, (마진?)
        val titleLabel = JLabel(configPull.maintitle(), SwingConstants.LEFT)
        titleLabel.foreground = configPull.textcolor()
        add(titleLabel, BorderLayout.CENTER)

        //TODO - 나가는키는 적용되었으니, 확장과 최소화키만 만들면 될듯?
        val closeButton = MainTitleBarButton("X")
        closeButton.addActionListener {
            mainWindow.dispose()
        }
        add(closeButton, BorderLayout.EAST)

        addMouseListener(object : MouseAdapter() {
            override fun mousePressed(e: MouseEvent) {
                xOffset = e.x
                yOffset = e.y
            }
        })
        addMouseMotionListener(object : MouseAdapter() {
            override fun mouseDragged(e: MouseEvent) {
                mainWindow.location = Point(
                    mainWindow.location.x + e.x - xOffset,
                    mainWindow.location.y + e.y - yOffset
                )
            }
        })
    }
}
