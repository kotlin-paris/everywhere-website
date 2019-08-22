package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import react.*
import react.dom.b
import react.dom.br
import react.dom.h2
import react.dom.span
import styled.css
import styled.styledDiv
import styled.styledP
import styled.styledSpan
import kotlin.browser.window

val talkingPoints = functionalComponent<RProps> {

    styledDiv {

        css {
            display = Display.flex
            flexDirection = FlexDirection.row
            color = Color.white
            margin(LinearDimension.auto)
            maxWidth = 45.em
            justifyContent = JustifyContent.spaceAround
            flexWrap = FlexWrap.wrap
            fontSize = 1.2.em

            kotlinx.css.h2 {
                textAlign = TextAlign.center
                margin(1.em)

                kotlinx.css.span {
                    fontWeight = FontWeight.normal
                }
            }
        }

        h2 {
            +"1"
            br {}
            span { +"Journée" }
        }

        h2 {
            +"3"
            br {}
            span { +"Workshops" }
        }

        h2 {
            +"10"
            br {}
            span { +"conférences" }
        }

        h2 {
            +"2"
            br {}
            span { +"codelabs" }
        }

    }

}
