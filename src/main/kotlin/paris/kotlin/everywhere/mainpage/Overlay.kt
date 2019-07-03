package paris.kotlin.everywhere.mainpage


import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.boxShadow
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import react.*
import styled.*
import kotlin.browser.window

class Overlay : RComponent<Overlay.Props, RState>() {

    interface Props : RProps {
        var onCloseSection: String
    }

    private val back = createRef<HTMLElement>()
    private val front = createRef<HTMLElement>()

    override fun RBuilder.render() {

        styledDiv {
            ref = back
            css {
                position = Position.fixed
                top = 0.px
                left = 0.px
                zIndex = 100
                width = 100.pct
                height = 100.pct
                backgroundColor = Color("#00000088")
            }
        }

        styledDiv {
            ref = front
            css {
                position = Position.fixed
                top = 0.px
                left = 0.px
                zIndex = 101
                width = 100.pct
                height = 100.pct
                display = Display.flex
                justifyContent = JustifyContent.center
                alignItems = Align.center
            }

            attrs {
                onClickFunction = {
                    close()
                }
            }

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
                    }

                    attrs {
                        onClickFunction = {
                            close()
                        }
                    }

                    +"x"
                }

                props.children()
            }

        }

    }

    override fun componentDidMount() {
        val back = this.back.current!!
        val front = front.current!!
        back.style.opacity = "0"

        front.style.transform = "translate(0, -30px)"
        front.style.opacity = "0"

        MainScope().launch {
            delay(1)
            back.style.transition = "opacity 0.3s"
            back.style.opacity = "1"
            front.style.transition = "transform 0.4s, opacity 0.3s"
            front.style.opacity = "1"
            front.style.transform = ""
        }
    }

    private fun close() {
        val back = this.back.current!!
        val front = front.current!!

        back.style.transition = "opacity 0.3s"
        front.style.transition = "transform 0.3s, opacity 0.3s"

        back.style.opacity = "0"

        front.style.transform = "translate(0, -30px)"
        front.style.opacity = "0"

        MainScope().launch {
            delay(301)
            window.location.hash = "/${props.onCloseSection}"
        }
    }

}