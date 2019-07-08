package paris.kotlin.everywhere.mainpage

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.boxShadow
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.events.Event
import react.*
import react.dom.a
import styled.css
import styled.styledA
import styled.styledDiv
import styled.styledSpan
import kotlin.browser.document
import kotlin.browser.window
import kotlin.math.max


class Header : RComponent<RProps, Header.State>() {

    interface State : RState {
        var isSmall: Boolean
        var hasTransition: Boolean
    }

    override fun State.init() {
        isSmall = false
        hasTransition = false
    }

    val initHeight = 350

    val div = createRef<HTMLDivElement>()

    override fun RBuilder.render() {

        styledDiv {
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
                position = Position.fixed
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

            child(Logo::class) {
                attrs {
                    isSmall = state.isSmall
                    hasTransition = state.hasTransition
                }
            }
        }

        styledSpan {
            css {
                display = Display.block
                height = initHeight.px
            }
        }
    }

    private var headerHeight = 0

    private fun setHeaderPos(isFirst: Boolean = false) {
        val scrollTop = window.scrollY
        if (isFirst || scrollTop < initHeight || headerHeight != 40) {
            headerHeight = max(40, initHeight - scrollTop.toInt())
            val scroll = initHeight - headerHeight
            val isSmall = headerHeight <= 165

            div.current!!.style.apply {
                height = "${headerHeight}px"
                backgroundPosition = "left ${-(scroll / 2.9)}px"
            }

            if (state.isSmall != isSmall || state.hasTransition != !isFirst)
                setState {
                    this.isSmall = isSmall
                    this.hasTransition = !isFirst
                }
        }
    }

    private val scrollCallback: (Event) -> Unit = { setHeaderPos() }

    override fun componentDidMount() {
        setHeaderPos(true)
        window.setTimeout({ setState { hasTransition = true } }, 500)
        document.addEventListener("scroll", scrollCallback)
    }

    override fun componentWillUnmount() {
        document.removeEventListener("scroll", scrollCallback)
    }
}
