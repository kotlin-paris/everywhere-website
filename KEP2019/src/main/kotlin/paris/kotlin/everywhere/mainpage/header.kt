package paris.kotlin.everywhere.mainpage

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.boxShadow
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kotlinx.html.classes
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.events.Event
import paris.kotlin.everywhere.utils.fchild
import paris.kotlin.everywhere.utils.getValue
import paris.kotlin.everywhere.utils.invoke
import paris.kotlin.everywhere.utils.provideDelegate
import react.*
import react.dom.a
import react.dom.span
import react.dom.style
import styled.css
import styled.styledA
import styled.styledDiv
import kotlin.browser.document
import kotlin.browser.window
import kotlin.math.max


private fun useScrollHeight(initHeight: Int) : Triple<RMutableRef<HTMLDivElement?>, Boolean, Boolean> {
    val div = useRef<HTMLDivElement?>(null)
    var isSmall by useState(false)
    var hasTransition by useState(false)

    var headerHeight = 0
    fun setHeaderPos(isFirst: Boolean = false) {
        val scrollTop = window.scrollY
        if (isFirst || scrollTop < initHeight || headerHeight != 40) {
            headerHeight = max(40, initHeight - scrollTop.toInt())
            val scroll = initHeight - headerHeight

            div.current!!.style.apply {
                height = "${headerHeight}px"
                backgroundPosition = "left ${-(scroll / 2.9)}px"
            }

            isSmall = (headerHeight <= 165)
            hasTransition = !isFirst
        }
    }

    useEffectWithCleanup(emptyList()) {
        setHeaderPos(true)
        window.setTimeout({ hasTransition = true }, 500)

        val scrollCallback: (Event) -> Unit = { setHeaderPos() }
        document.addEventListener("scroll", scrollCallback)

        ({ document.removeEventListener("scroll", scrollCallback) })
    }

    return Triple(div, isSmall, hasTransition)
}

interface HeaderProps : RProps {
    var isStatic: Boolean
}

val header by functionalComponent<HeaderProps> {
    val initHeight = 350

    val (div, isSmall, hasTransition) = useScrollHeight(initHeight)

    style {
        attrs["suppressHydrationWarning"] = true

        if (!it.isStatic) {
            +CSSBuilder().apply {
                "div.header" {
                    position = Position.fixed
                }
                "span.headerSpan" {
                    display = Display.block
                    height = initHeight.px
                }
            }.toString()
        }
    }

    styledDiv {
        attrs.classes += "header"
        attrs["suppressHydrationWarning"] = true

        ref = div
        css {
            height = initHeight.px
            backgroundColor = Color.silver
            backgroundImage = Image("url('header-background.svg')")
            backgroundRepeat = BackgroundRepeat.noRepeat
            backgroundPosition = "left center"
            backgroundSize = "624px"
            display = Display.flex
            flexDirection = FlexDirection.column
            justifyContent = JustifyContent.center
            alignItems = Align.center
            width = 100.pct
            top = 0.px
            overflow = Overflow.hidden
            zIndex = 10
            boxShadow(Color.black, blurRadius = 5.px)
        }

        styledDiv {
            css {
                position = Position.absolute
                top = 0.px
                left = 10.px
                height = 40.px
                color = Color.black
                fontSize = 0.8.em
                cursor = Cursor.default
                display = Display.flex
                flexDirection = FlexDirection.column
                alignContent = Align.center
                justifyContent = JustifyContent.center

                "a" {
                    color = Color.black
                    textDecoration = TextDecoration.none
                    fontWeight = FontWeight.normal
                    cursor = Cursor.pointer
                }
            }
        }

        styledDiv {
            css {
                position = Position.absolute
                top = 0.px
                right = 0.px
                display = Display.flex
                justifyContent = JustifyContent.flexEnd
                alignItems = Align.center
                padding(0.px, 6.px)
                fontSize = 0.7.em

                "a" {
                    display = Display.block
                    margin(2.px, 2.px, 0.px, 2.px)
                    fontWeight = FontWeight.w700
                    padding(10.px, 6.px)
                    borderRadius = 5.px
                    textDecoration = TextDecoration.none
                    color = Color.dimGray
                    cursor = Cursor.pointer
                    transition("background-color", duration = 0.15.s)

                    hover {
                        backgroundColor = Color("#FFFFFF44")
                    }

                    media("(max-width: 970px)") {
                        display = Display.none
                    }
                }

            }
            styledA(href = "https://www.eventbrite.fr/e/billets-kotlineverywhere-paris-2019-64962254853") {
                css {
                    specific {
                        color = Color.white
                        padding(10.px, 18.px)
                        display = Display.inline
                        backgroundColor = Color.steelBlue

                        hover {
                            backgroundColor = Color.cornflowerBlue
                            color = Color.white
                        }
                    }
                }

                +"BILLETS"
            }
            a(href = "#/agenda") { +"AGENDA" }
            a(href = "#/sponsors") { +"SPONSORS" }
            a(href = "#/speakers") { +"SPEAKERS" }
            a(href = "#/talks") { +"TALKS" }
            a(href = "#/contact") { +"CONTACT" }
            a(href = "https://forms.gle/R9vvrErsGcfepC2e6") { +"CALL 4 PAPERS" }
        }

        fchild(logo {
            this.isSmall = isSmall
            this.hasTransition = hasTransition
        })
    }

    span("headerSpan") {}
}
