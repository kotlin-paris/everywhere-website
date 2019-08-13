package paris.kotlin.everywhere.mainpage

import kotlinx.css.*
import kotlinx.css.properties.*
import kotlinx.html.js.onClickFunction
import paris.kotlin.everywhere.data.speakers
import paris.kotlin.everywhere.data.talks
import paris.kotlin.everywhere.utils.getValue
import react.*
import react.dom.*
import styled.css
import styled.styledA
import styled.styledDiv
import kotlin.browser.window


interface SpeakerProps : RProps {
    var id: String
}

val speaker by functionalComponent<SpeakerProps> {
    val speaker = speakers[it.id] ?: return@functionalComponent

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

            "p.links" {
                paddingTop = 0.5.em

                "img" {
                    height = 2.em
                    marginBottom = 0.em
                    padding(0.em, 1.em)
                }
            }

            "p.text" {
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

            "p.talks" {
                display = Display.block
                alignSelf = Align.flexStart
            }
        }

        img(src = "speakers/${speaker.id}.jpg") {}
        h3 { +speaker.name }
        speaker.company?.let { h4 { +it } }
        if (speaker.twitter != null || speaker.webSite != null) {
            p("links") {
                speaker.twitter?.let {
                    a(href = "https://twitter.com/$it", target = "_blank") { img(src = "twitter.svg") {} }
                }
                speaker.webSite?.let {
                    a(href = it, target = "_blank") { img(src = "link.svg") {} }
                }
            }
        }
        p("text") { +speaker.description }

        hr {}

        p("talks") {
            speaker.talks.mapNotNull { talks[it] }.forEach { talk ->
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
