package paris.kotlin.everywhere.mainpage

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import paris.kotlin.everywhere.keYellow
import paris.kotlin.everywhere.utils.getValue
import paris.kotlin.everywhere.utils.provideDelegate
import react.*
import react.dom.a
import react.dom.b
import react.dom.br
import styled.css
import styled.styledP
import styled.styledSpan
import kotlin.browser.window


private fun RBuilder.useAnimatedWordList(wordList: List<String>, outTimeout: Int, inTimeout: Int) : Pair<String, Double> {
    var index by useState { 0 }
    var shown by useState { true }
    var alpha by useState { 1.0 }

    useEffectWithCleanup(listOf(shown)) {
        val tid = if (shown) {
            alpha = 0.0
            window.setTimeout({ shown = false }, outTimeout)
        } else {
            index = (index + 1) % wordList.size
            alpha = 1.0
            window.setTimeout({ shown = true }, inTimeout)
        }

        ({ window.clearTimeout(tid) })
    }

    return wordList[index] to alpha
}

interface SubHeaderProps : RProps {
    var isStatic: Boolean
}

val subHeader by functionalComponent<SubHeaderProps> {

    val (word, alpha) = useAnimatedWordList(listOf("Android", "le Cloud", "iOS", "le Web"), 210, 1200)

    styledP {
        css {
            color = Color.white
            padding(50.px, 25.px, 15.px, 25.px)
            fontSize = 1.5.em
            textAlign = TextAlign.center

            "b" {
                fontSize = 1.3.em
            }

            "a" {
                color = Color.lightSkyBlue
                textDecoration = TextDecoration.none
                fontWeight = FontWeight.bold
            }
        }

        +"Le "
        b { +"19 octobre 2019" }
        +", sur le "
        a(href="https://goo.gl/maps/aHpRuZs8NAxtMiob6") { +"campus d'Epitech Paris" }
        +","
        br {}
        +"un rendez-vous pour mettre Kotlin dans "

        styledSpan {
            attrs["suppressHydrationWarning"] = true

            css {
                display = Display.inlineBlock
                textAlign = TextAlign.left
                color = Color.keYellow
                width = 4.em
                opacity = alpha
                transition("all", 200.ms)
            }

            +(if (it.isStatic) "..." else word)
        }
    }

}
