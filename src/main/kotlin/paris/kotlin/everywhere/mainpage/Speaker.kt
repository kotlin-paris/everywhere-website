package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.*
import kotlinx.html.js.onClickFunction
import paris.kotlin.everywhere.data.speakers
import paris.kotlin.everywhere.data.talks
import react.*
import react.dom.*
import styled.css
import styled.styledA
import styled.styledDiv
import kotlin.browser.window

class Speaker : RComponent<Speaker.Props, RState>() {

    interface Props : RProps {
        var id: String
    }

    override fun RBuilder.render() {

        val speaker = speakers[props.id] ?: return

        styledDiv {
            css {
                display = Display.flex
                flexDirection = FlexDirection.column
                justifyContent = JustifyContent.center
                alignItems = Align.center

                "img" {
                    borderRadius = 10.px
                }

                "h3" {
                    fontSize = 1.5.em
                    padding(0.8.em, 0.px)
                    textAlign = TextAlign.center
                }

                "p" {
                    alignSelf = Align.stretch
                }

                "hr" {
                    alignSelf = Align.stretch
                    backgroundColor = Color.silver
                    height = 1.px
                    borderStyle = BorderStyle.none
                    margin(0.8.em, 0.em)
                }
            }

            img(src = "speakers/${speaker.id}.jpg") {}
            h3 { +speaker.name }
            p { +speaker.description }

            speaker.talks.mapNotNull { talks[it] }.forEach { talk ->
                hr {}
                p {
                    styledA(href = "#/agenda/${talk.id}") {
                        css {
                            color = Color.cornflowerBlue
                            textDecoration = TextDecoration.none
                            transition("color", 0.3.s)

                            hover {
                                color = Color.steelBlue
                            }
                        }
                        b {
                            if (talk.isWorkshop)
                                +"Workshop "
                            +talk.title
                        }
                    }
                }
            }
        }

    }

}