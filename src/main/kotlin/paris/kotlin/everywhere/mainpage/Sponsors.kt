package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import kotlinx.css.properties.boxShadowInset
import kotlinx.html.P
import paris.kotlin.everywhere.MainPage
import react.*
import react.dom.*
import styled.*

class Sponsors : RComponent<Sponsors.Props, RState>() {

    interface Props: RProps, MainPage.HasAnchor

    override fun RBuilder.render() {

        styledDiv {
            ref = props.scrollTo
            css {
                margin(20.px, 0.px)
                padding(2.em, 0.px)
                backgroundColor = Color.silver
                boxShadowInset(Color.black, blurRadius = 3.px)
            }

            styledH1 {
                css {
                    textAlign = TextAlign.center
                }

                +"Sponsors"
            }

            styledDiv {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    justifyContent = JustifyContent.center
                    flexWrap = FlexWrap.wrap
                    alignItems = Align.center

                    "a" {
                        margin(1.em)
                        "img" {
                            maxWidth = 100.pct
                        }
                    }
                }

                a(href = "https://kodein.net") {
                    styledImg(alt = "Kodein Koders", src = "kodein-logo.svg") {
                        css { maxHeight = 70.px }
                    }
                }
                a(href = "https://epitech.eu/") {
                    styledImg(alt = "Epitech", src = "epitech-logo.png") {
                        css { maxHeight = 90.px }
                    }
                }
            }


        }

    }


}