package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.ms
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import paris.kotlin.everywhere.keYellow
import paris.kotlin.everywhere.utils.getValue
import react.*
import react.dom.*
import styled.css
import styled.styledDiv
import styled.styledP
import styled.styledSpan
import kotlin.browser.window

val tickets by functionalComponent<RProps> {
    styledP {
        css {
            color = Color.white
            padding(50.px, 25.px)
            fontSize = 1.3.em
            textAlign = TextAlign.center

            "a" {
                display = Display.inlineBlock
                margin(2.px, 2.px, 0.px, 2.px)
                fontWeight = FontWeight.bold
                padding(10.px, 18.px)
                borderRadius = 5.px
                textDecoration = TextDecoration.none
                color = Color.white
                cursor = Cursor.pointer
                transition("background-color", duration = 0.15.s)
                backgroundColor = Color.steelBlue

                hover {
                    backgroundColor = Color.cornflowerBlue
                    color = Color.white
                }
            }
        }

        +"Réservez votre "
        a(href="https://www.eventbrite.fr/e/billets-kotlineverywhere-paris-2019-64962254853") { +"BILLET" }
        +" dès aujourd'hui !"
    }
}
