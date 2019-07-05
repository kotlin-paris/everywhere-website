package paris.kotlin.everywhere.mainpage

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.boxShadow
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import paris.kotlin.everywhere.MainPage
import paris.kotlin.everywhere.data.talks
import paris.kotlin.everywhere.keYellow
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import styled.css
import styled.styledDiv

class Workshops : RComponent<Workshops.Props, RState>() {

    interface Props: RProps, MainPage.HasAnchor

    private fun RBuilder.renderWorkshop(id: String) {
        a(href="#/agenda/$id") {
            b { +"Workshop" }
            br {}
            +talks[id]!!.title
        }

    }

    override fun RBuilder.render() {
        styledDiv {
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
                        borderRadius = 10.px
                        backgroundColor = Color.keYellow
                        margin(0.pct, 2.pct)
                        color = Color.black
                        textDecoration = TextDecoration.none
                        padding(1.em)
                        textAlign = TextAlign.center
                        transition(duration = 0.3.s)

                        hover {
                            boxShadow(Color.black, blurRadius = 12.px)
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
                renderWorkshop("workshop-server")

            }

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

                renderWorkshop("workshop-coroutines")
            }

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

                renderWorkshop("workshop-multiplatform")
            }

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

                renderWorkshop("workshop-server")
            }
        }
    }
}