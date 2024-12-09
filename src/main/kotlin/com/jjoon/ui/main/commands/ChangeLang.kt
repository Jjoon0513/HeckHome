package com.jjoon.ui.main.commands

import com.jjoon.ui.main.MainTextArea
import com.jjoon.util.ConfigLoader
import com.jjoon.util.LangLoader

class ChangeLang(
    input: List<String>,
    textArea: MainTextArea,
    maincommands: MainCommands
)
{
    private val mc = maincommands
    private val cl = ConfigLoader()
    private val inp = input
    private val langloader = LangLoader(cl.getProperty("language"))

    private fun help(): String{
        return """
            언어를 변경시켜줍니다
            - 이 명령은 하나의 인수가 필요합니다.
            
            lang <Target>
            
            <Target>: 이곳엔 언어를 바꿀 대상이 들어가게 됩니다
            예를 들어 기본 설정은 en으로 설정되어 있습니다.
        """.trimIndent()
    }
    fun changelang(): String {
        try {
            cl.pushProperty("language", inp[1])
            LangLoader(inp[1])
            mc.reloadlang()
        } catch (e: IndexOutOfBoundsException){
            return help()
        } catch (e: IllegalArgumentException){
            return "${inp[1]}을(를) 찾을수 없습니다."
        }

        return "성공적으로 완료되었습니다."
    }
}