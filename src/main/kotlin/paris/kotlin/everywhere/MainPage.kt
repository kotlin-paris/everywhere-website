package paris.kotlin.everywhere

import org.w3c.dom.*
import paris.kotlin.everywhere.mainpage.*
import react.*
import kotlin.browser.window

class MainPage : RComponent<MainPage.Props, RState>() {

    interface Props : RProps {
        var section: String?
        var id: String?
    }

    interface HasAnchor {
        var scrollTo: RReadableRef<HTMLElement>
    }

    private val anchors = HashMap<String, RReadableRef<HTMLElement>>()

    private var previousSection = ""
    private var previousId: String? = null

    override fun RBuilder.render() {
        child(Header::class) {}
        child(SubHeader::class) {}
        child(TalkingPoints::class) {}
        child(Agenda::class) {
            attrs {
                scrollTo = anchors.getOrPut("agenda") { createRef() }
            }
        }
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
        child(Contact::class) {
            attrs {
                scrollTo = anchors.getOrPut("contact") { createRef() }
            }
        }

//        if (props.section == "tickets")
//            child(Overlay::class) {
//                attrs {
//                    onCloseSection = previousSection
//                }
//                child(Tickets::class) {}
//            }
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

    override fun componentWillReceiveProps(nextProps: Props) {
        previousId = props.id
        previousSection = props.section ?: ""

        if (props.section != nextProps.section) {
            if (previousId == null) {
                val offset = getOffset(nextProps.section)
                if (offset != -1)
                    window.scrollTo(ScrollToOptions(0.0, offset.toDouble(), ScrollBehavior.SMOOTH))
            }
        }
    }
}