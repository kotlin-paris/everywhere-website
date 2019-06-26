package paris.kotlin.everywhere

import kotlinx.css.*
import kotlinx.css.properties.boxShadow
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
//                fontSize = 1.25.em
//                media("(max-width: 880px)") {
//                    fontSize = 1.1.em
//                }
//                media("(max-width: 380px)") {
//                    fontSize = 1.em
//                }
            }

//            "#app" {
//                maxWidth = 1040.px
//                margin(LinearDimension.auto)
//                textAlign = TextAlign.center
//                boxShadow(Color.gray, blurRadius = 2.px)
//            }
        }

        child(App::class) {}
    }
}
