package paris.kotlin.everywhere.mainpage

import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import paris.kotlin.everywhere.HasAnchor
import paris.kotlin.everywhere.data.speakers
import paris.kotlin.everywhere.data.talks
import paris.kotlin.everywhere.utils.getValue
import react.*
import react.dom.*
import styled.css
import styled.styledDiv
import styled.styledH1


interface TalksProps: RProps, HasAnchor

private fun RBuilder.renderTalk(id: String) {
    a(href="#/agenda/$id") {
        val talk = talks[id]!!

        b { +talk.title }
        i {
            +talk.speakers.map { speakers.getValue(it).name }.joinToString()
        }
    }

}

val talks by functionalComponent<TalksProps> {
    styledH1 {
        ref = it.scrollTo

        css {
            textAlign = TextAlign.center
            color = Color.silver
            paddingTop = 1.em
        }

        +"Talks"
    }

    styledDiv {
        css {
            margin(LinearDimension.auto)
            paddingTop = 2.em
            paddingBottom = 0.2.em
            display = Display.flex
            flexDirection = FlexDirection.row
            flexWrap = FlexWrap.wrap
            alignItems = Align.center
            justifyContent = JustifyContent.center
            maxWidth = 60.em

            "a" {
                display = Display.block
                boxShadow(Color.black, blurRadius = 3.px)
                borderRadius = 0.4.em
                backgroundColor = Color.whiteSmoke
                margin(0.em, 1.em , 2.em, 1.em)
                padding(1.em)
                textAlign = TextAlign.left
                width = 240.px

                hover {
                    boxShadow(Color.black, blurRadius = 12.px)
                }

                "i" {
                    fontSize = 0.75.em
                    display = Display.block
                    textAlign = TextAlign.left
                    paddingTop = 1.em
                    color = Color.gray
                }
            }
        }

        talks.filterNot { it.value.isWorkshop } .keys.forEach { renderTalk(it) }
    }
}
