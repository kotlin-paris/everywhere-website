package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.border
import kotlinx.css.properties.boxShadow
import kotlinx.html.js.onClickFunction
import react.*
import styled.*
import kotlin.browser.window

class Overlay : RComponent<Overlay.Props, RState>() {

    interface Props : RProps {
        var onCloseSection: String
    }

    override fun RBuilder.render() {

        styledDiv {
            css {
                position = Position.fixed
                top = 0.px
                left = 0.px
                zIndex = 100
                width = 100.pct
                height = 100.pct
                backgroundColor = Color("#00000088")
                display = Display.flex
                justifyContent = JustifyContent.center
                alignItems = Align.center
            }

            attrs {
                onClickFunction = {
                    println(window.location.hash)
                    window.location.hash = "/${props.onCloseSection}"
                    println(window.location.hash)
                }
            }

            styledDiv {
                css {
                    backgroundColor = Color.silver
                    boxShadow(Color.black, blurRadius = 5.px, spreadRadius = 1.px)
                    padding(2.em)
                    borderRadius = 0.5.em
                }

                props.children()
            }
        }

    }


}