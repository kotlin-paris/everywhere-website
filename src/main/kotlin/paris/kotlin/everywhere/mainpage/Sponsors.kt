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
                padding(2.em)
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
                    alignItems = Align.center
                    padding(2.em)

                    "a" {
                        margin(1.em)
                    }
                }

                a(href = "https://kodein.net") {
                    styledImg(alt = "Kodein Koders", src = "kodein-logo.svg") {
                        css { height = 65.px }
                    }
                }
                a(href = "https://epitech.eu/") {
                    styledImg(alt = "Epitech", src = "epitech-logo.png") {
                        css { height = 90.px }
                    }
                }
            }


        }

    }


}