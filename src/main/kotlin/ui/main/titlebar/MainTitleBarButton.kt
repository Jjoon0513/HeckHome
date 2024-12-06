package com.jjoon.ui.main.titlebar

import com.jjoon.util.ConfigPull
import util.Animation
import java.awt.Color
import java.awt.Insets
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.BorderFactory
import javax.swing.JButton
import javax.swing.Timer
//TODO - 글래스 겉표면 색을 따로 지정할수있게 해줘야할듯.
// foreground 색을 변경할수 있도록.
class MainTitleBarButton(
    textin: String
) : JButton(textin) {
    private val configPull = ConfigPull()

    init {
        layout = null
        margin = Insets(10, 10, 10, 10)
        border = BorderFactory.createLineBorder(configPull.textcolor(), 2)
        background = configPull.bgcolor()
        foreground = configPull.textcolor()
        preferredSize = java.awt.Dimension(50, 50)
        isFocusPainted = false

        val animation = Animation()
        val txc = configPull.textcolor()
        val bgc = configPull.bgcolor()

        var apeardI = 0.0
        var disapeardI = 255.0

        val apeard = Timer(10, null)
        val disapeard = Timer(10, null)
        //TODO - 변수에 animation.inoutsine에 할당해놓고 R,G,B에 따로할당
        // 그리고 때었을때 안 텍스트가 안보임 (검정색)
        
        apeard.addActionListener {
            apeardI = (apeardI + 0.01).coerceIn(0.0, 1.0)
            foreground = Color((bgc.rgb.toDouble() * animation.inoutsine(apeardI)).toInt())
            background = Color((txc.rgb.toDouble() * animation.inoutsine(apeardI)).toInt())
            if (apeardI >= 1.0) apeard.stop()
        }

        disapeard.addActionListener {
            disapeardI = (disapeardI - 0.01).coerceIn(0.0, 1.0)
            background = Color((bgc.rgb.toDouble() * animation.inoutsine(disapeardI)).toInt())
            foreground = Color((txc.rgb.toDouble() * animation.inoutsine(disapeardI)).toInt())
            if (disapeardI <= 0.0) disapeard.stop()
        }

        // 마우스 리스너 추가
        addMouseListener(object : MouseAdapter() {
            override fun mouseEntered(e: MouseEvent?) {
                if (!apeard.isRunning) { // 중복 실행 방지
                    apeardI = disapeardI // 현재 상태에서 시작
                    apeard.start()
                    disapeard.stop()
                }
            }

            override fun mouseExited(e: MouseEvent?) {
                if (!disapeard.isRunning) { // 중복 실행 방지
                    disapeardI = apeardI // 현재 상태에서 시작
                    disapeard.start()
                    apeard.stop()
                }
            }
        })
    }
}
