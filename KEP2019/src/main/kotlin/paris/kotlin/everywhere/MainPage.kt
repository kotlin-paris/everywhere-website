package paris.kotlin.everywhere

import org.w3c.dom.*
import paris.kotlin.everywhere.mainpage.*
import react.*
import kotlin.browser.window

class MainPage : RComponent<MainPage.Props, RState>() {

    interface Props : RProps {
        var section: String?
        var id: String?
        var isStatic: Boolean
    }

    interface HasAnchor {
        var scrollTo: RReadableRef<HTMLElement>
    }

    private val anchors = HashMap<String, RReadableRef<HTMLElement>>()

    override fun RBuilder.render() {
        child(Popup::class) {
            attrs {
                section = props.section
                id = props.id
            }
        }

        child(Header::class) {
            attrs {
                isStatic = props.isStatic
            }
        }
        child(SubHeader::class) {}
        child(TalkingPoints::class) {}
        child(Workshops::class) {
            attrs {
                scrollTo = anchors.getOrPut("agenda") { createRef() }
            }
        }
        child(Agenda::class) {}
        child(Tickets::class) {}
        child(Sponsors::class) {
            attrs {
                scrollTo = anchors.getOrPut("sponsors") { createRef() }
            }
        }
        child(Speakers::class) {
            attrs {
                scrollTo = anchors.getOrPut("speakers") { createRef() }
            }
        }
        child(Talks::class) {
            attrs {
                scrollTo = anchors.getOrPut("talks") { createRef() }
            }
        }
        child(Tickets::class) {}
        child(Contact::class) {
            attrs {
                scrollTo = anchors.getOrPut("contact") { createRef() }
            }
        }
    }

    private fun getOffset(anchor: String?): Int {
        anchor ?: return 100
        val scrollTo = anchors[anchor]?.current ?: return -1
        return scrollTo.offsetTop - 60
    }

    override fun componentDidMount() {
        if (props.section != null) {
            val offset = getOffset(props.section)
            if (offset != -1)
                window.scrollTo(ScrollToOptions(0.0, offset.toDouble(), ScrollBehavior.INSTANT))
        }
    }

    override fun UNSAFE_componentWillReceiveProps(nextProps: Props) {
        if (props.section != nextProps.section) {
            if (props.id == null && nextProps.id == null) {
                val offset = getOffset(nextProps.section)
                if (offset != -1)
                    window.scrollTo(ScrollToOptions(0.0, offset.toDouble(), ScrollBehavior.SMOOTH))
            }
        }
    }

//    private fun managePopup(props: Props) = MainScope().launch {
//        val section = props.section
//        val elementId = props.id
//
//        val container = document.getElementById("popup")!!
//
//        closePopup?.let { it() }
//        closePopup = null
//
//        if (section == null || elementId == null) {
//            unmountComponentAtNode(container)
//            return@launch
//        }
//    }
}