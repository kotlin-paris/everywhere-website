package paris.kotlin.everywhere

import org.w3c.dom.*
import paris.kotlin.everywhere.mainpage.*
import paris.kotlin.everywhere.utils.fchild
import paris.kotlin.everywhere.utils.getValue
import paris.kotlin.everywhere.utils.invoke
import paris.kotlin.everywhere.utils.provideDelegate
import react.*
import kotlin.browser.window


interface HasAnchor {
    var scrollTo: RMutableRef<HTMLElement?>
}

private data class MainPageState(val previousSection: String?, val previousId: String?) {
    sealed class Action {
        data class Move(val section: String?, val id: String?) : Action()
    }

    fun dispatch(action: Action) = when (action) {
        is Action.Move -> copy(previousSection = action.section, previousId = action.id)
    }
}

val mainPage by functionalComponent<AppProps> {
    val anchors = listOf("speakers", "sponsors", "agenda", "contact").associateWith { useRef<HTMLElement?>(null) }

    fun getOffset(anchor: String?): Int {
        anchor ?: return 100
        val scrollTo = anchors[anchor]?.current ?: return -1
        return scrollTo.offsetTop - 60
    }

    useEffect(emptyList()) {
        if (it.section != null) {
            val offset = getOffset(it.section)
            if (offset != -1)
                window.scrollTo(ScrollToOptions(0.0, offset.toDouble(), ScrollBehavior.INSTANT))
        }
    }

    val (state, dispatch) = useReducer(MainPageState::dispatch, MainPageState(null, null))

    useEffect(listOf(it.section, it.id)) {
        if (state.previousSection != it.section) {
            if (state.previousId == null && it.id == null) {
                val offset = getOffset(it.section)
                if (offset != -1)
                    window.scrollTo(ScrollToOptions(0.0, offset.toDouble(), ScrollBehavior.SMOOTH))
            }
        }
        dispatch(MainPageState.Action.Move(it.section, it.id))
    }

    fchild(popup {
        section = it.section
        id = it.id
    })

    fchild(header { isStatic = it.isStatic })

    fchild(subHeader { isStatic = it.isStatic })

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
