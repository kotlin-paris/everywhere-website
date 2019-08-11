package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.boxShadowInset
import paris.kotlin.everywhere.MainPage
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.a
import react.dom.div
import react.dom.h1
import styled.css
import styled.styledDiv
import styled.styledImg

class Sponsors : RComponent<Sponsors.Props, RState>() {

    interface Props: RProps, MainPage.HasAnchor

    override fun RBuilder.render() {

        styledDiv {
            ref = props.scrollTo
            css {
                margin(20.px, 0.px)
                padding(1.em, 0.px)
                backgroundColor = Color.silver
                boxShadowInset(Color.black, blurRadius = 3.px)

                "h1" {
                    textAlign = TextAlign.center
                    color = Color.dimGray
                    paddingTop = 1.em
                }

                "div" {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    justifyContent = JustifyContent.center
                    flexWrap = FlexWrap.wrap
                    alignItems = Align.center
                    padding(0.px, 1.em)

                    "a" {
                        margin(1.em)
                        "img" {
                            maxWidth = 100.pct
                        }
                    }
                }
            }

            h1 {
                +"Organisateurs"
            }

            div {
                a(href = "https://kodein.net") {
                    styledImg(alt = "Kodein Koders", src = "kodein-logo.svg") {
                        css { maxHeight = 70.px }
                    }
                }
                a(href = "https://epitech.eu") {
                    styledImg(alt = "Epitech", src = "epitech-logo.png") {
                        css { maxHeight = 90.px }
                    }
                }
            }

            h1 {
                +"Sponsors Silver"
            }

            div {
                a(href = "https://kaibee.fr") {
                    styledImg(alt = "Keibee", src = "kaibee-logo.png") {
                        css { maxHeight = 100.px }
                    }
                }
            }

        }

    }


}