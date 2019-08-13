package paris.kotlin.everywhere.mainpage

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import paris.kotlin.everywhere.utils.getValue
import react.RProps
import react.dom.div
import react.functionalComponent
import styled.*

interface LogoProps : RProps {
    var isSmall: Boolean
    var hasTransition: Boolean
}

val logo by functionalComponent<LogoProps> {

    styledDiv {
        attrs["suppressHydrationWarning"] = true
        css {
            display = Display.flex
            flexDirection = FlexDirection.row
            alignItems = Align.center
            justifyContent = JustifyContent.center

            if (it.isSmall) {
                marginRight = 690.px

                media("(max-width: 970px)") {
                    marginRight = 16.em
                }
                media("(max-width: 540px)") {
                    marginRight = 2.em
                }
            }
            if (it.hasTransition)
                transition(duration = 0.3.s)
        }

        styledImg(alt = "Kotlin/Everywhere logo", src = "logo.png") {
            attrs["suppressHydrationWarning"] = true
            css {
                display = Display.block
                height = if (it.isSmall) 1.7.em else 9.em

                if (!it.isSmall)
                    media("(max-width: 420px)") {
                        fontSize = 0.8.em
                    }

                if (it.hasTransition)
                    transition(duration = 0.3.s)
            }
        }

        div {
            styledH1 {
                attrs["suppressHydrationWarning"] = true
                css {
                    fontWeight = FontWeight.w700
                    textAlign = TextAlign.left
                    width = 6.5.em
                    height = 4.05.em

                    if (!it.isSmall)
                        media("(max-width: 420px)") {
                            fontSize = 1.6.em
                        }
                }

                styledA(href = "#/") {
                    css {
                        universal {
                            color = Color.black
                        }
                        textDecoration = TextDecoration.none

                        hover {
                            color = Color.black
                        }
                    }

                    styledDiv {
                        attrs["suppressHydrationWarning"] = true
                        css {
                            position = Position.relative
                            display = Display.flex
                            flexDirection = if (it.isSmall) FlexDirection.row else FlexDirection.column
                            justifyContent = JustifyContent.center
                        }

                        styledSpan {
                            attrs["suppressHydrationWarning"] = true
                            css {
                                display = Display.block
                                position = Position.absolute
                                top = if (it.isSmall) 1.80.em else 0.em
                                left = if (it.isSmall) 0.2.em else 0.5.em

                                fontSize = if (it.isSmall) 0.8.em else 1.em

                                media("(max-width: 540px)") {
                                    if (it.isSmall)
                                        opacity = 0.0
                                }

                                if (it.hasTransition)
                                    transition(duration = 0.3.s)
                            }

                            +"KOTLIN/"
                        }

                        styledSpan {
                            attrs["suppressHydrationWarning"] = true
                            css {
                                display = Display.block
                                position = Position.absolute
                                top = if (it.isSmall) 1.80.em else 1.35.em
                                left = if (it.isSmall) 4.37.em else 0.5.em

                                fontSize = if (it.isSmall) 0.8.em else 1.em

                                media("(max-width: 540px)") {
                                    if (it.isSmall) {
                                        left = 0.2.em
                                        opacity = 0.0
                                    }
                                }

                                if (it.hasTransition)
                                    transition(duration = 0.3.s)
                            }

                            +"Everywhere"
                        }

                        styledSpan {
                            attrs["suppressHydrationWarning"] = true
                            css {
                                display = Display.block
                                width = 5.em
                                position = Position.absolute
                                top = if (it.isSmall) 1.80.em else 2.70.em
                                left = if (it.isSmall) 10.50.em else 0.5.em
                                fontWeight = FontWeight.normal

                                fontSize = if (it.isSmall) 0.8.em else 1.em

                                media("(max-width: 540px)") {
                                    if (it.isSmall)
                                        left = 0.2.em
                                }

                                if (it.hasTransition)
                                    transition(duration = 0.3.s)
                            }

                            +"Paris 2019"
                        }

                    }
                }
            }
        }
    }

}