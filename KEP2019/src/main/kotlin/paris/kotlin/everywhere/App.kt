package paris.kotlin.everywhere

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import react.RBuilder
import react.ReactElement
import styled.css
import styled.styledDiv

val Color.Companion.keYellow get() = Color("#fff582")

fun RBuilder.app(props: MainPage.Props): ReactElement {

    return styledDiv {
        css {
            universal {
                margin(0.px)
                padding(0.px)
            }

            backgroundColor = Color("#393939")
            fontFamily = "'Open Sans', sans-serif"

            a {
                color = Color.steelBlue
                transition(duration = 0.3.s)
                textDecoration = TextDecoration.none

                hover {
                    color = Color.cornflowerBlue
                }
            }
        }

        child(MainPage::class.js, props) {}
    }
}
