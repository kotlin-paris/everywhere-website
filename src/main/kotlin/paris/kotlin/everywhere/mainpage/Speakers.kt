package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.*
import kotlinx.html.unsafe
import paris.kotlin.everywhere.MainPage
import paris.kotlin.everywhere.data.speakers
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
                margin(1.em, LinearDimension.auto)
                paddingTop = 1.em
                maxWidth = 60.em

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
                a(href = "#/speakers/$id") {
                    img(src = "speakers/$id.jpg") {}
                    val speaker = speakers.getValue(id)
                    b { +speaker.name }
                    i { speaker.company?.let { +it } ?: attrs.unsafe { +"&nbsp;" } }
                }
            }

            for (id in speakers.filter { it.value.featured.not() } .keys.sorted()) {
                a(href = "#/speakers/$id") {
                    img(src = "speakers/$id.jpg") {}
                    val speaker = speakers.getValue(id)
                    b { +speaker.name }
                    i { speaker.company?.let { +it } ?: attrs.unsafe { +"&nbsp;" } }
                }
            }

        }

    }


}