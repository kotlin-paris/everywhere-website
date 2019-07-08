package paris.kotlin.everywhere.mainpage

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import react.*
import react.dom.div
import styled.*

class Logo : RComponent<Logo.Props, RState>() {

    interface Props : RProps {
        var isSmall: Boolean?
        var hasTransition: Boolean?
    }

    override fun RBuilder.render() {

        val isSmall = props.isSmall ?: false
        val hasTransition = props.hasTransition ?: false

        styledDiv {
            css {
                display = Display.flex
                flexDirection = FlexDirection.row
                alignItems = Align.center
                justifyContent = JustifyContent.center

                if (isSmall) {
                    marginRight = 690.px

                    media("(max-width: 970px)") {
                        marginRight = 16.em
                    }
                    media("(max-width: 540px)") {
                        marginRight = 2.em
                    }
                }
                if (hasTransition)
                    transition(duration = 0.3.s)
            }

            styledImg(alt = "Kotlin/Everywhere logo", src = "logo.png") {
                css {
                    display = Display.block
                    height = if (isSmall) 1.7.em else 9.em

                    if (!isSmall)
                        media("(max-width: 420px)") {
                            fontSize = 0.8.em
                        }

                    if (hasTransition)
                        transition(duration = 0.3.s)
                }
            }

            div {
                styledH1 {
                    css {
                        fontWeight = FontWeight.w700
                        textAlign = TextAlign.left
                        width = 6.5.em
                        height = 4.05.em

                        if (!isSmall)
                            media("(max-width: 420px)") {
                                fontSize = 1.6.em
                            }
                    }

                    styledA(href = "#/") {
                        css {
                            color = Color.black
                            textDecoration = TextDecoration.none

                            hover {
                                color = Color.black
                            }
                        }

                        styledDiv {
                            css {
                                position = Position.relative
                                display = Display.flex
                                flexDirection = if (isSmall) FlexDirection.row else FlexDirection.column
                                justifyContent = JustifyContent.center
                            }

                            styledSpan {
                                css {
                                    display = Display.block
                                    position = Position.absolute
                                    top = if (isSmall) 1.80.em else 0.em
                                    left = if (isSmall) 0.2.em else 0.5.em

                                    fontSize = if (isSmall) 0.8.em else 1.em

                                    media("(max-width: 540px)") {
                                        if (isSmall)
                                            opacity = 0.0
                                    }

                                    if (hasTransition)
                                        transition(duration = 0.3.s)
                                }

                                +"KOTLIN/"
                            }

                            styledSpan {
                                css {
                                    display = Display.block
                                    position = Position.absolute
                                    top = if (isSmall) 1.80.em else 1.35.em
                                    left = if (isSmall) 4.37.em else 0.5.em

                                    fontSize = if (isSmall) 0.8.em else 1.em

                                    media("(max-width: 540px)") {
                                        if (isSmall) {
                                            left = 0.2.em
                                            opacity = 0.0
                                        }
                                    }

                                    if (hasTransition)
                                        transition(duration = 0.3.s)
                                }

                                +"Everywhere"
                            }

                            styledSpan {
                                css {
                                    display = Display.block
                                    width = 5.em
                                    position = Position.absolute
                                    top = if (isSmall) 1.80.em else 2.70.em
                                    left = if (isSmall) 10.50.em else 0.5.em
                                    fontWeight = FontWeight.normal

                                    fontSize = if (isSmall) 0.8.em else 1.em

                                    media("(max-width: 540px)") {
                                        if (isSmall)
                                            left = 0.2.em
                                    }

                                    if (hasTransition)
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
}
