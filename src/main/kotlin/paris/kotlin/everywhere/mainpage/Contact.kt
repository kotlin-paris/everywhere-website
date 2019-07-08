package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import kotlinx.css.properties.boxShadowInset
import kotlinx.html.P
import paris.kotlin.everywhere.MainPage
import react.*
import react.dom.*
import styled.*

class Contact : RComponent<Contact.Props, RState>() {

    interface Props: RProps, MainPage.HasAnchor

    override fun RBuilder.render() {

        styledH1 {
            ref = props.scrollTo
            css {
                textAlign = TextAlign.center
                color = Color.silver
                paddingTop = 1.em
            }

            +"Contact"
        }

        styledDiv {
            css {
                display = Display.flex
                flexDirection = FlexDirection.row
                justifyContent = JustifyContent.center
                alignItems = Align.center
                padding(20.px)

                "a img" {
                    height = 3.em
                    padding(2.em)
                }
            }

            a(href = "https://twitter.com/kotlin_paris") {
                img(alt = "Twitter", src = "twitter.svg") {}
            }

            a(href = "mailto:everywhere@kotlin.paris") {
                img(alt = "E-mail", src = "email.svg") {}
            }
        }

    }

}
