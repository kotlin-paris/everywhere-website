package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.boxShadowInset
import paris.kotlin.everywhere.HasAnchor
import paris.kotlin.everywhere.utils.getValue
import react.*
import react.dom.a
import react.dom.div
import react.dom.h1
import styled.css
import styled.styledDiv
import styled.styledImg

interface SponsorsProps: RProps, HasAnchor

val sponsors by functionalComponent<SponsorsProps> {
    styledDiv {
        ref = it.scrollTo
        css {
            margin(20.px, 0.px)
            padding(1.em, 0.px)
            backgroundColor = Color.silver
            boxShadowInset(Color.black, blurRadius = 3.px)

            "h1" {
                textAlign = TextAlign.center
                color = Color.dimGray
                paddingTop = 1.em
            }

            "div" {
                display = Display.flex
                flexDirection = FlexDirection.row
                justifyContent = JustifyContent.center
                flexWrap = FlexWrap.wrap
                alignItems = Align.center
                padding(0.px, 1.em)

                "a" {
                    margin(1.em, 1.5.em)
                    "img" {
                        maxWidth = 100.pct
                    }
                }
            }
        }

        h1 {
            +"Sponsor Platinum :"
        }

        div {
            a(href = "https://www.octo.com/") {
                styledImg(alt = "Octo", src = "octo-logo.svg") {
                    css {
                        height = 9.em
                        marginTop = 0.5.em
                    }
                }
            }
        }

        h1 {
            +"Sponsors Gold :"
        }

        div {
            a(href = "https://www.malt.fr") {
                styledImg(alt = "Malt", src = "malt-logo.svg") {
                    css { height = 6.5.em }
                }
            }

            a(href = "https://www.kapten.com/fr/") {
                styledImg(alt = "Kapten", src = "kapten-logo.svg") {
                    css { height = 3.5.em ; padding(0.5.em) }
                }
            }
        }

        h1 {
            +"Sponsors Silver :"
        }

        div {
            a(href = "https://kaibee.fr") {
                styledImg(alt = "Kaibee", src = "kaibee-logo.png") {
                    css { height = 7.0.em }
                }
            }

            a(href = "https://www.joza-it.fr") {
                styledImg(alt = "Joza IT", src = "joza-it-logo.svg") {
                    css { height = 7.0.em }
                }
            }

            a(href = "https://www.smile.eu/fr") {
                styledImg(alt = "Smile", src = "smile-logo.svg") {
                    css { height = 7.0.em }
                }
            }
        }

        h1 {
            +"Organisateurs :"
        }

        div {
            a(href = "https://kodein.net") {
                styledImg(alt = "Kodein Koders", src = "kodein-logo.svg") {
                    css { height = 5.0.em }
                }
            }
            a(href = "https://epitech.eu") {
                styledImg(alt = "Epitech", src = "epitech-logo.png") {
                    css { height = 5.5.em }
                }
            }
        }
    }

}
