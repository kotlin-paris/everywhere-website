package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.*
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import react.*
import styled.css
import styled.styledA
import styled.styledDiv
import kotlin.browser.window

class Overlay : RComponent<Overlay.Props, RState>() {

    interface Props : RProps {
        var onCloseSection: String
        var id: String
        var transitionState: String
    }

    override fun RBuilder.render() {

        styledDiv {
            css {
                if (props.transitionState == "exited") visibility = Visibility.hidden
                position = Position.fixed
                top = 0.px
                left = 0.px
                zIndex = 100
                width = 100.pct
                height = 100.pct
                backgroundColor = Color("#00000088")

                transition("opacity", 0.3.s)

                when (props.transitionState) {
                    "exiting", "exited" -> {
                        opacity = 0.0
                    }
                    "entering", "entered" -> {
                        opacity = 1.0
                    }
                }
            }
        }

        styledDiv {
            css {
                if (props.transitionState == "exited") visibility = Visibility.hidden

                position = Position.fixed
                top = 0.px
                left = 0.px
                zIndex = 101
                width = 100.pct
                height = 100.pct
                display = Display.flex
                justifyContent = JustifyContent.center
                alignItems = Align.center

                transition("transform", 0.4.s)
                transition("opacity", 0.3.s)

                when (props.transitionState) {
                    "exiting", "exited" -> {
                        opacity = 0.0
                        transform {
                            translate(0.px, (-30).px)
                        }
                    }
                    "entering", "entered" -> {
                        opacity = 1.0
                    }
                }
            }

            attrs {
                onClickFunction = {
                    window.location.hash = "/${props.onCloseSection}"
                }
            }

            if (props.transitionState == "exited") return@styledDiv

            styledDiv {
                css {
                    width = 75.pct
                    maxWidth = 500.px
                    maxHeight = 80.pct
                    overflow = Overflow.auto
                    backgroundColor = Color.white
                    boxShadow(Color.black, blurRadius = 5.px, spreadRadius = 1.px)
                    padding(2.em)
                    borderRadius = 0.5.em
                    position = Position.relative
                }

                attrs {
                    onClickFunction = {
                        it.stopPropagation()
                    }
                }

                styledA {
                    css {
                        fontWeight = FontWeight.bold
                        color = Color.silver
                        textDecoration = TextDecoration.none
                        position = Position.absolute
                        right = 1.em
                        top = 0.5.em
                        cursor = Cursor.pointer
                        transition("color", 0.3.s)

                        hover {
                            color = Color.dimGray
                        }
                    }

                    attrs {
                        onClickFunction = {
                            window.location.hash = "/${props.onCloseSection}"
                        }
                    }

                    +"x"
                }

                children()
            }

        }

    }


}