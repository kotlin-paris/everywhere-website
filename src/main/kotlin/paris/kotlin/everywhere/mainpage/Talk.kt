package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.*
import paris.kotlin.everywhere.data.speakers
import paris.kotlin.everywhere.data.talks
import react.*
import react.dom.*
import styled.css
import styled.styledA
import styled.styledDiv

class Talk : RComponent<Talk.Props, RState>() {

    interface Props : RProps {
        var id: String
    }

    override fun RBuilder.render() {

        val talk = talks[props.id] ?: return

        styledDiv {
            css {
                "h3" {
                    padding(0.6.em, 0.px)
                    fontSize = 1.em
                }

                "p" {
                    margin(0.5.em, 0.em)
                    put("text-indent", 3.em.value)
                    fontSize = 0.9.em
                }

                "hr" {
                    backgroundColor = Color.silver
                    height = 1.px
                    borderStyle = BorderStyle.none
                    margin(0.8.em, 0.em)
                }

                "a" {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    alignItems = Align.center
                    color = Color.cornflowerBlue
                    textDecoration = TextDecoration.none
                    transition("color", 0.3.s)
                    margin(1.em)

                    hover {
                        color = Color.steelBlue
                    }

                    "img" {
                        width = 80.px
                        borderRadius = 5.px
                    }

                    "b" {
                        fontWeight = FontWeight.bold
                        paddingLeft = 1.5.em
                    }
                }
            }

            h3 {
                if (talk.isWorkshop) {
                    +"Workshop"
                    br {}
                }
                +talk.title
            }

            talk.description.lines().forEach {
                p { +it }
            }

            hr {}

            talk.speakers.mapNotNull { speakers[it] } .forEach { speaker ->

                a(href = "#/speakers/${speaker.id}") {
                    img(src = "speakers/${speaker.id}.jpg") {}

                    b { +speaker.name }
                }
            }

        }

    }

}