package paris.kotlin.everywhere

import org.w3c.dom.*
import paris.kotlin.everywhere.data.talks
import paris.kotlin.everywhere.mainpage.*
import paris.kotlin.everywhere.utils.coerceToNull
import paris.kotlin.everywhere.utils.fchild
import paris.kotlin.everywhere.utils.getValue
import paris.kotlin.everywhere.utils.invoke
import react.*
import kotlin.browser.window
import kotlin.random.Random


interface HasAnchor {
    var scrollTo: RMutableRef<HTMLElement?>
}

private data class MainPageState(val previousSection: String?, val previousId: String?, val currentSection: String?, val currentId: String?) {

    sealed class Action {
        data class Move(val section: String?, val id: String?) : Action()
    }

    fun dispatch(action: Action): MainPageState {
        return when (action) {
            is Action.Move -> copy(previousSection = currentSection, previousId = currentId, currentSection = action.section, currentId = action.id)
        }
    }
}

val mainPage by functionalComponent<AppProps> { props ->
    val anchors = listOf("speakers", "sponsors", "agenda", "contact").associateWith { useRef<HTMLElement?>(null) }

    fun getOffset(anchor: String?): Int {
        anchor ?: return 100
        val scrollTo = anchors[anchor]?.current ?: return -1
        return scrollTo.offsetTop - 60
    }

    useEffect(emptyList()) {
        if (props.section != null) {
            val offset = getOffset(props.section)
            if (offset != -1)
                window.scrollTo(ScrollToOptions(0.0, offset.toDouble(), ScrollBehavior.INSTANT))
        }
    }

    val (state, dispatch) = useReducer(MainPageState::dispatch, MainPageState(null, null, null, null))

    useEffect(listOf(props.section, props.id)) {
        dispatch(MainPageState.Action.Move(props.section.coerceToNull(), props.id.coerceToNull()))
    }

    useEffect(listOf(state.currentSection)) {
        with (state) {
            if (previousSection != currentSection) {
                if (previousId == null && currentId == null) {
                    val offset = getOffset(currentSection)
                    if (offset != -1)
                        window.scrollTo(ScrollToOptions(0.0, offset.toDouble(), ScrollBehavior.SMOOTH))
                }
            }
        }
    }

    fchild(popup {
        section = props.section
        id = props.id
    })

    fchild(header { isStatic = props.isStatic })

    fchild(subHeader { isStatic = props.isStatic })

    fchild(talkingPoints)

    fchild(speakers {
        scrollTo = anchors.getValue("speakers")
    })

    fchild(tickets)

    fchild(sponsors {
        scrollTo = anchors.getValue("sponsors")
    })

    fchild(agenda {
        scrollTo = anchors.getValue("agenda")
    })

    fchild(tickets)

    fchild(contact {
        scrollTo = anchors.getValue("contact")
    })
}
