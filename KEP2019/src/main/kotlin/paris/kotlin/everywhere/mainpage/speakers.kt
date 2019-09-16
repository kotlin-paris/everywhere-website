package paris.kotlin.everywhere.mainpage

import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import kotlinx.html.unsafe
import paris.kotlin.everywhere.HasAnchor
import paris.kotlin.everywhere.data.speakers
import paris.kotlin.everywhere.utils.getValue
import react.RBuilder
import react.RProps
import react.dom.a
import react.dom.b
import react.dom.i
import react.dom.img
import react.functionalComponent
import styled.css
import styled.styledDiv
import styled.styledH1


fun RBuilder.renderSpeaker(id: String) {
    a(href = "#/speakers/$id") {
        img(src = "speakers/$id.jpg") {
            attrs {
                width = "200px"
                height = "200px"
            }
        }
        val speaker = speakers.getValue(id)
        b { +speaker.name }
        i { speaker.company?.let { +it } ?: attrs.unsafe { +"&nbsp;" } }
    }
}

interface SpeakersProps: RProps, HasAnchor

val speakers by functionalComponent<SpeakersProps> {

    styledDiv {
        ref = it.scrollTo

        css {
            display = Display.flex
            flexDirection = FlexDirection.row
            flexWrap = FlexWrap.wrap
            alignItems = Align.center
            justifyContent = JustifyContent.center
            margin(1.em, LinearDimension.auto)
            paddingTop = 1.em
            maxWidth = 75.em

            "a" {
                backgroundColor = Color.whiteSmoke
                display = Display.flex
                flexDirection = FlexDirection.column
                boxShadow(Color.black, blurRadius = 3.px)
                borderRadius = 0.4.em
                overflow = Overflow.hidden
                margin(1.em)
                paddingBottom = 0.8.em

                hover {
                    boxShadow(Color.black, blurRadius = 12.px)
                }

                "b" {
                    fontSize = 1.1.em
                    padding(0.8.em, 0.5.em, 0.em, 0.5.em)
                }

                "i" {
                    fontSize = 0.75.em
                    display = Display.block
                    textAlign = TextAlign.left
                    padding(0.em, 0.7.em)
                    color = Color.gray
                }
            }
        }

        for (id in speakers.filter { it.value.featured }.keys.sorted()) {
            renderSpeaker(id)
        }

        for (id in speakers.filter { it.value.featured.not() } .keys.sorted()) {
            renderSpeaker(id)
        }

    }

}
