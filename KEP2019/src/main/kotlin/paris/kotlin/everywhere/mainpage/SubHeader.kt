package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import paris.kotlin.everywhere.keYellow
import react.*
import react.dom.a
import react.dom.b
import react.dom.br
import styled.css
import styled.styledP
import styled.styledSpan
import kotlin.browser.window

class SubHeader : RComponent<RProps, SubHeader.State>() {

    val targets = arrayOf("Android", "le Cloud", "iOS", "le Web")

    interface State : RState {
        var index: Int
        var alpha: Double
    }

    override fun State.init() {
        index = 0
        alpha = 1.0
    }

    override fun RBuilder.render() {
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
            a(href="https://goo.gl/maps/9rqQKUzPV7hkEdqc7") { +"campus d'Epitech Paris" }
            +","
            br {}
            +"un rendez-vous pour mettre Kotlin dans "

            styledSpan {
                css {
                    display = Display.inlineBlock
                    textAlign = TextAlign.left
                    color = Color.keYellow
                    width = 4.em
                    opacity = state.alpha
                    transition("all", 200.ms)
                }

                +targets[state.index]
            }
        }
    }

    var timeoutId: Int = 0

    fun nextStep(step: Int) {
        when (step) {
            0 -> {
                setState { alpha = 0.0 }
                timeoutId = window.setTimeout({ nextStep(1) }, 210)
            }
            1 -> {
                setState { index = (index + 1) % targets.size ; alpha = 1.0  }
                timeoutId = window.setTimeout({ nextStep(0) }, 1200)
            }
        }

    }

    override fun componentDidMount() {
        timeoutId = window.setTimeout({ nextStep(0) }, 1000)
    }

    override fun componentWillUnmount() {
        window.clearInterval(timeoutId)
    }

}