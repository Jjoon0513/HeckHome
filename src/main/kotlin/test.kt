import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.BorderFactory
import java.awt.Color

fun main() {
    // JFrame 생성
    val frame = JFrame("JButton Border Example")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(300, 200)

    // JButton 생성
    val button = JButton("Click Me")

    // 배경색과 글자색 변경
    button.background = Color(255, 87, 51)
    button.foreground = Color.WHITE

    // 버튼 테두리 제거
    button.border = BorderFactory.createEmptyBorder() // 테두리 제거
    button.isFocusPainted = false

    // 버튼을 프레임에 추가
    frame.add(button)

    // 프레임 표시
    frame.isVisible = true
}
