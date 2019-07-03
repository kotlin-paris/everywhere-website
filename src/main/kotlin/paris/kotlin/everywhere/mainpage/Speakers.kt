package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.*
import paris.kotlin.everywhere.MainPage
import react.*
import react.dom.*
import styled.*

class Speakers : RComponent<Speakers.Props, RState>() {

    interface Props: RProps, MainPage.HasAnchor

    override fun RBuilder.render() {

        styledH1 {
            ref = props.scrollTo

            css {
                textAlign = TextAlign.center
                color = Color.silver
                paddingTop = 1.em
            }

            +"Speakers"
        }

        styledDiv {
            css {
                display = Display.flex
                flexDirection = FlexDirection.row
                flexWrap = FlexWrap.wrap
                alignItems = Align.center
                justifyContent = JustifyContent.center
                margin(1.em)
                paddingTop = 1.em

                "a" {
                    backgroundColor = Color.silver
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    boxShadow(Color.black, blurRadius = 3.px)
                    borderRadius = 0.4.em
                    overflow = Overflow.hidden
                    color = Color.black
                    textDecoration = TextDecoration.none
                    transition(duration = 0.3.s)

                    hover {
                        boxShadow(Color.black, blurRadius = 12.px)
                    }

                    "b" {
                        fontSize = 1.1.em
                        padding(0.8.em, 0.em, 0.8.em, 0.5.em)
                    }
                }
            }

            a(href = "#/speakers/sebastien-deleuze") {
                img(src = "speakers/sebastien-deleuze.jpg") {}
                b {
                    +"Sébastien Deleuze"
                }
            }

        }

    }


}