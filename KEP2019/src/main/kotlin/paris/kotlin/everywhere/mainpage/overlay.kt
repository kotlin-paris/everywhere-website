package paris.kotlin.everywhere.mainpage

import kotlinx.css.*
import kotlinx.css.properties.*
import kotlinx.html.js.onClickFunction
import paris.kotlin.everywhere.utils.getValue
import paris.kotlin.everywhere.utils.provideDelegate
import react.RProps
import react.dom.style
import react.functionalComponent
import react.useEffect
import react.useState
import styled.css
import styled.inlineStyles
import styled.styledA
import styled.styledDiv
import kotlin.browser.window


interface OverlayProps : RProps {
    var onCloseSection: String
    var id: String
    var transitionState: TransitionState
}

val overlay by functionalComponent<OverlayProps> { props ->

    var hasRendered by useState(false)
    useEffect(listOf(hasRendered)) { hasRendered = true }

    if (!hasRendered)
        return@functionalComponent

    styledDiv {
        this.inlineStyles {
            if (props.transitionState == TransitionState.EXITED) visibility = Visibility.hidden
            when {
                props.transitionState.isExit -> {
                    opacity = 0.0
                }
                props.transitionState.isEnter -> {
                    opacity = 1.0
                }
            }
        }

        css {
            position = Position.fixed
            top = 0.px
            left = 0.px
            zIndex = 100
            width = 100.pct
            height = 100.pct
            backgroundColor = Color("#00000088")

            transition("opacity", 0.3.s)
        }
    }

    styledDiv {
        inlineStyles {
            if (props.transitionState == TransitionState.EXITED) visibility = Visibility.hidden
            when {
                props.transitionState.isExit -> {
                    opacity = 0.0
                    transform {
                        translate(0.px, (-30).px)
                    }
                }
                props.transitionState.isEnter -> {
                    opacity = 1.0
                }
            }
        }

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

            transition("transform", 0.4.s)
            transition("opacity", 0.3.s)
        }

        attrs {
            onClickFunction = {
                window.location.hash = "/${props.onCloseSection}"
            }
        }

        if (props.transitionState == TransitionState.EXITED) return@styledDiv

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

            props.children()
        }

    }

}
