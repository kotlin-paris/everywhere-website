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
            }

        }

        child(App::class) {}
    }
}
