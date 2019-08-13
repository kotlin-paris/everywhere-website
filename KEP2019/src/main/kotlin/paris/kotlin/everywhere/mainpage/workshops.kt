package paris.kotlin.everywhere.mainpage

import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import paris.kotlin.everywhere.HasAnchor
import paris.kotlin.everywhere.data.speakers
import paris.kotlin.everywhere.data.talks
import react.RBuilder
import react.RProps
import react.dom.*
import react.functionalComponent
import styled.css
import styled.styledDiv


interface WorkshopsProps: RProps, HasAnchor

private fun RBuilder.renderWorkshop(id: String) {
    a(href="#/agenda/$id") {
        val talk = talks[id]!!

        +"Workshop"
        br {}
        b { +talk.title }
        i {
            +talk.speakers.map { speakers.getValue(it).name }.joinToString()
        }
    }
}

private fun RBuilder.renderSingleWorkshop(id: String) {
    styledDiv {
        css {
            maxWidth = 28.em

            media("(min-width: 700px)") {
                specific {
                    display = Display.none
                }
            }

            "a" {
                width = 63.5.pct
            }
        }

        h3 {
            +"9h00"
        }

        renderWorkshop(id)
    }
}


val workshops = functionalComponent<WorkshopsProps> {
    styledDiv {
        ref = it.scrollTo
        css {
            margin(20.px, 1.em, 60.px, 1.em)

            "h3" {
                color = Color.white
                textAlign = TextAlign.left
                flexGrow = 1.0
            }

            "div" {
                margin(LinearDimension.auto)
                paddingTop = 2.em
                paddingBottom = 0.2.em
                display = Display.flex
                flexDirection = FlexDirection.row
                alignItems = Align.center
                justifyContent = JustifyContent.flexEnd

                "a" {
                    display = Display.block
                    boxShadow(Color.black, blurRadius = 3.px)
                    borderRadius = 0.4.em
                    backgroundColor = Color.whiteSmoke
                    margin(0.pct, 2.pct)
                    padding(1.em)
                    textAlign = TextAlign.left

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

        }

        styledDiv {
            css {
                maxWidth = 51.em

                media("(max-width: 700px)") {
                    specific {
                        display = Display.none
                    }
                }

                "a" {
                    width = 21.5.pct
                }
            }

            h3 {
                +"9h00"
            }

            renderWorkshop("workshop-coroutines")
            renderWorkshop("workshop-multiplatform")
            renderWorkshop("workshop-cloud")

        }

        renderSingleWorkshop("workshop-coroutines")
        renderSingleWorkshop("workshop-multiplatform")
        renderSingleWorkshop("workshop-cloud")
    }
}
