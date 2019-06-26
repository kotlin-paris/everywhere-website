package paris.kotlin.everywhere.mainpage


import paris.kotlin.everywhere.MainPage
import react.*
import styled.*

class Speakers : RComponent<Speakers.Props, RState>() {

    interface Props: RProps, MainPage.HasAnchor

    override fun RBuilder.render() {

        styledDiv {
            ref = props.scrollTo
        }

    }


}