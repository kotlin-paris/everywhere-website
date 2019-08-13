package paris.kotlin.everywhere

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import paris.kotlin.everywhere.utils.fchild
import paris.kotlin.everywhere.utils.getValue
import paris.kotlin.everywhere.utils.plus
import react.RProps
import react.functionalComponent
import styled.css
import styled.styledDiv

val Color.Companion.keYellow get() = Color("#fff582")

interface AppProps : RProps {
    var section: String?
    var id: String?
    var isStatic: Boolean
}

val app by functionalComponent<AppProps> {

    styledDiv {
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

        fchild(mainPage + it)
    }
}
