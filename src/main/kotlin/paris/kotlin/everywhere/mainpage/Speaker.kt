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
                    marginBottom = 0.5.em
                }

                "h3" {
                    fontSize = 1.5.em
                    textAlign = TextAlign.center
                }
                "h4" {
                    fontWeight = FontWeight.normal
                }

                "p" {
                    paddingTop = 0.8.em
                    alignSelf = Align.stretch
                    fontSize = 0.9.em
                }

                "hr" {
                    alignSelf = Align.stretch
                    backgroundColor = Color.silver
                    height = 1.px
                    borderStyle = BorderStyle.none
                    margin(0.8.em, 0.em)
                }

                "a" {
                    display = Display.block
                    alignSelf = Align.flexStart
                }
            }

            img(src = "speakers/${speaker.id}.jpg") {}
            h3 { +speaker.name }
            speaker.company?.let { h4 { +it } }
            p { +speaker.description }

            speaker.talks.mapNotNull { talks[it] }.forEach { talk ->
                hr {}
                a(href = "#/agenda/${talk.id}") {
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