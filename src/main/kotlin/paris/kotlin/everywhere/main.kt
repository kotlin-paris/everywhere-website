package paris.kotlin.everywhere

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.boxShadow
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import react.dom.render
import styled.StyledComponents
import styled.injectGlobal
import kotlin.browser.document
import kotlin.browser.window

val Color.Companion.keYellow get() = Color("#fff582")

fun main() {

    render(document.getElementById("app")) {
        StyledComponents.injectGlobal {
            universal {
                margin(0.px)
                padding(0.px)
            }

            body {
                backgroundColor = Color("#393939")
                fontFamily = "'Open Sans', sans-serif"
            }

            a {
                color = Color.steelBlue
                transition(duration = 0.3.s)
                textDecoration = TextDecoration.none

                hover {
                    color = Color.cornflowerBlue
                }
            }

        }

        child(App::class) {}
    }
}
