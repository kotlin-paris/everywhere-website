package paris.kotlin.everywhere

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.w3c.dom.*
import paris.kotlin.everywhere.mainpage.*
import react.*
import react.dom.render
import react.dom.unmountComponentAtNode
import kotlin.browser.document
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

    private var onPopupCloseSection = ""
    private var onPopupCloseId: String? = null

    override fun RBuilder.render() {
        child(Header::class) {}
        child(SubHeader::class) {}
        child(TalkingPoints::class) {}
        child(Workshops::class) {
            attrs {
                scrollTo = anchors.getOrPut("agenda") { createRef() }
            }
        }
        child(Talks::class) {}
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

        managePopup(props)
    }

    override fun componentWillReceiveProps(nextProps: Props) {
        if (props.section != nextProps.section) {
            if (props.id == null && nextProps.id == null) {
                val offset = getOffset(nextProps.section)
                if (offset != -1)
                    window.scrollTo(ScrollToOptions(0.0, offset.toDouble(), ScrollBehavior.SMOOTH))
            }
        }

        if (props.id == null) {
            onPopupCloseId = props.id
            onPopupCloseSection = props.section ?: ""
        }

        managePopup(nextProps)
    }

    var closePopup: (suspend () -> Unit)? = null

    private fun managePopup(props: Props) = MainScope().launch {
        val section = props.section
        val elementId = props.id

        val container = document.getElementById("popup")!!

        closePopup?.let { it() }
        closePopup = null

        if (section == null || elementId == null) {
            unmountComponentAtNode(container)
            return@launch
        }

        val popup = buildElement {
            child(Overlay::class) {
                attrs {
                    id = "$section/$elementId"
                    onCloseSection = onPopupCloseSection
                    setClose = { closePopup = it }
                }

                when (props.section) {
                    "speakers" -> {
                        child(Speaker::class) {
                            attrs {
                                id = elementId
                            }
                        }
                    }
                    "agenda" -> {
                        child(Talk::class) {
                            attrs {
                                id = elementId
                            }
                        }
                    }
                }
            }
        }

        render(popup, container)
    }
}