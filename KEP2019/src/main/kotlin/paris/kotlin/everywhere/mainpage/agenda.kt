package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import paris.kotlin.everywhere.HasAnchor
import paris.kotlin.everywhere.data.Slot
import paris.kotlin.everywhere.data.agenda
import paris.kotlin.everywhere.utils.getValue
import react.RBuilder
import react.RProps
import react.dom.*
import react.functionalComponent
import styled.css
import styled.styledDiv

private fun RBuilder.renderTalk(id: String, where: String) {
    a(href="#/agenda/$id") {
        val talk = paris.kotlin.everywhere.data.talks[id]!!

        talk.type.prefix?.let { small { +it } }

        b { +talk.title }
        i {
            +talk.speakers.map { paris.kotlin.everywhere.data.speakers.getValue(it).name }.joinToString()
        }
        i {
            +where
        }
    }
}

interface AgendaProps: RProps, HasAnchor

val agenda by functionalComponent<AgendaProps> {

    styledDiv {
        ref = it.scrollTo
        css {
            margin(LinearDimension.auto)
            paddingTop = 2.em
            paddingBottom = 0.2.em
            maxWidth = 51.em

            "h3" {
                color = Color.white
                width = 4.em
            }

            "div.line" {
                display = Display.flex
                flexDirection = FlexDirection.row
                alignItems = Align.center
                margin(1.5.em, 0.em)

                media("(max-width: 850px)") {
                    flexDirection = FlexDirection.column
                }

                "a" {
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    justifyContent = JustifyContent.center
                    boxShadow(Color.black, blurRadius = 3.px)
                    borderRadius = 0.4.em
                    backgroundColor = Color.whiteSmoke
                    margin(0.em, 0.75.em)
                    padding(0.8.em)
                    textAlign = TextAlign.left
                    width = 12.em
                    height = 7.5.em

                    media("(max-width: 850px)") {
                        margin(0.75.em, 0.em)
                    }

                    hover {
                        boxShadow(Color.black, blurRadius = 12.px)
                    }

                    "b" {
                        flexGrow = 1.0
                    }

                    "i" {
                        fontSize = 0.75.em
                        display = Display.block
                        textAlign = TextAlign.left
                        paddingTop = 0.2.em
                        color = Color.gray
                    }

                    +"soon" {
                        color = Color.gray
                    }
                }

                "p" {
                    flexGrow = 1.0
                    textAlign = TextAlign.center
                    color = Color.white
                    fontSize = 1.2.em
                    padding(1.em)
                }
            }
        }

        for (slot in agenda) {
            div("line") {
                h3 { +slot.time }
                when (slot) {
                    is Slot.Break -> p { +slot.title }
                    is Slot.Talks -> for (talk in slot.talks) {
                        renderTalk(talk.talkId, talk.where)
                    }
                }
            }
        }

//        div("line") {
//            h3 { +"8h20" }
//            p {
//                +"Accueil des workshopeurs & petit déjeuner"
//            }
//        }
//
//        div("line") {
//            h3 { +"09h00" }
//            renderTalk("workshop-coroutines")
//            renderTalk("workshop-multiplatform")
//            renderTalk("workshop-cloud")
//        }
//
//        div("line") {
//            h3 { +"12h30" }
//            p {
//                +"Accueil & buffet repas"
//            }
//        }
//
//        div("line") {
//            h3 { +"13h30" }
//            renderTalk("ouverture")
//        }
//
//        div("line") {
//            h3 { +"14h00" }
//            renderTalk("spring")
//            renderTalk("native-lib")
//        }
//
//        div("line") {
//            h3 { +"15h00" }
//            p {
//                +"Pause & rafraichissements"
//            }
//        }
//
//        div("line") {
//            h3 { +"15h20" }
//            renderTalk("declarative-ui")
//            renderTalk("workflows")
//            renderTalk("codelab-arrow")
//        }
//
//        div("line") {
//            h3 { +"16h20" }
//            renderTalk("androidx-coroutines")
//            renderTalk("react")
//        }
//
//        div("line") {
//            h3 { +"16h50" }
//            p {
//                +"Pause & rafraichissements"
//            }
//        }
//
//        div("line") {
//            h3 { +"17h10" }
//            renderTalk("fullstack")
//            renderTalk("multiplatform-kotlin13")
//            renderTalk("codelab-spring")
//        }
//
//        div("line") {
//            h3 { +"18h10" }
//            renderTalk("gradle-dsl")
//            renderTalk("study-lib-coroutines")
//        }
//
//        div("line") {
//            h3 { +"18h40" }
//            renderTalk("cloture")
//        }
//
//        div("line") {
//            h3 { +"19h00" }
//            p {
//                +"Buffet & bières !"
//            }
//        }

    }
}
