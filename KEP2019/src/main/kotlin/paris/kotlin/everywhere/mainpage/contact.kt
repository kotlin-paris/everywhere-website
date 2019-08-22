package paris.kotlin.everywhere.mainpage


import kotlinx.css.*
import kotlinx.css.properties.boxShadowInset
import paris.kotlin.everywhere.HasAnchor
import paris.kotlin.everywhere.utils.getValue
import react.RProps
import react.dom.a
import react.dom.img
import react.functionalComponent
import styled.css
import styled.styledDiv
import styled.styledH1

interface ContactProps: RProps, HasAnchor

val contact by functionalComponent<ContactProps> {

    styledDiv {
        ref = it.scrollTo
        css {
            backgroundColor = Color.silver
            boxShadowInset(Color.black, blurRadius = 3.px)
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

        a(href = "https://twitter.com/kotlin_paris", target = "_blank") {
            img(alt = "Twitter", src = "twitter.svg") {}
        }

        a(href = "https://www.reddit.com/r/Kotlin/comments/cf5tm6/kotlineverywhere_paris/", target = "_blank") {
            img(alt = "Reddit", src = "reddit.svg") {}
        }

        a(href = "https://www.linkedin.com/company/kotlin-everywhere-paris", target = "_blank") {
            img(alt = "LinkedIn", src = "linkedin.svg") {}
        }

        a(href = "mailto:everywhere@kotlin.paris", target = "_blank") {
            img(alt = "E-mail", src = "email.svg") {}
        }
    }
}
