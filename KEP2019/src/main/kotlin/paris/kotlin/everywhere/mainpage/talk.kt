package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.*
import paris.kotlin.everywhere.data.speakers
import paris.kotlin.everywhere.data.talks
import paris.kotlin.everywhere.utils.getValue
import react.*
import react.dom.*
import styled.css
import styled.styledA
import styled.styledDiv

interface TalkProps : RProps {
    var id: String
}

val talk by functionalComponent<TalkProps> {

    val talk = talks[it.id] ?: return@functionalComponent

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
                margin(1.em)

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
            talk.type.prefix?.let {
                +it
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
