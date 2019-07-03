package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import paris.kotlin.everywhere.data.speakers
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h3
import react.dom.img
import react.dom.p
import styled.css
import styled.styledDiv

class Speaker : RComponent<Speaker.Props, RState>() {

    interface Props : RProps {
        var id: String
    }

    override fun RBuilder.render() {

        val speaker = speakers[props.id] ?: return

        styledDiv {
            css {
                display = Display.flex
                flexDirection = FlexDirection.column
                justifyContent = JustifyContent.center
                alignItems = Align.center

                "h3" {
                    fontSize = 1.5.em
                    padding(0.8.em, 0.px)
                }
            }

            img(src = "speakers/${props.id}.jpg") {}
            h3 { +speaker.name }
            p { +speaker.description }
        }

    }

}