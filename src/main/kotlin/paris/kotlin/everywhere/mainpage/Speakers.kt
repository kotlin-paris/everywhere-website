package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.*
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

                    hover {
                        boxShadow(Color.black, blurRadius = 12.px)
                    }

                    "b" {
                        fontSize = 1.1.em
                        padding(0.8.em, 0.em, 0.8.em, 0.5.em)
                    }
                }
            }

            for (id in speakers.filter { it.value.featured }.keys.sorted()) {
                a(href = "#/speakers/$id") {
                    img(src = "speakers/$id.jpg") {}
                    b {
                        +speakers[id]!!.name
                    }
                }
            }

            for (id in speakers.filter { it.value.featured.not() } .keys.sorted()) {
                a(href = "#/speakers/$id") {
                    img(src = "speakers/$id.jpg") {}
                    b {
                        +speakers[id]!!.name
                    }
                }
            }

        }

    }


}