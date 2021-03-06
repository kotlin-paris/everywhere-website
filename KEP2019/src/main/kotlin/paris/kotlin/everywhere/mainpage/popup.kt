package paris.kotlin.everywhere.mainpage

import paris.kotlin.everywhere.utils.*
import react.*
import kotlin.browser.window

enum class TransitionState(val isEnter: Boolean) {
    ENTERING(true),
    ENTERED(true),
    EXITING(false),
    EXITED(false);

    val isExit: Boolean get() = !isEnter
}

fun useTransition(show: Boolean, timeout: Int): TransitionState {
    var state by useState(if (show) TransitionState.ENTERED else TransitionState.EXITED)
    var isShowing by useState(show)

    useEffectWithCleanup(listOf(state, show)) {
        when {
            show && !isShowing && state != TransitionState.EXITED -> {
                state = TransitionState.EXITED
                ({})
            }
            show && !isShowing && state == TransitionState.EXITED -> {
                isShowing = true
                state = TransitionState.ENTERING
                ({})
            }
            show && state == TransitionState.ENTERING -> {
                val tid = window.setTimeout({ state = TransitionState.ENTERED }, timeout)
                ({ window.clearTimeout(tid) })
            }
            !show && isShowing && state != TransitionState.ENTERED -> {
                state = TransitionState.ENTERED
                ({})
            }
            !show && isShowing && state == TransitionState.ENTERED -> {
                isShowing = false
                state = TransitionState.EXITING
                ({})
            }
            !show && state == TransitionState.EXITING -> {
                val tid = window.setTimeout({ state = TransitionState.EXITED }, timeout)
                ({ window.clearTimeout(tid) })
            }
            else -> ({})
        }
    }

    return state
}

interface PopupProps : RProps {
    var section: String?
    var id: String?
}

private data class PopupState(val section: String?, val id: String?, val previousSection: String?) {
    sealed class Action {
        data class Move(val section: String?, val id: String?) : Action()
        data class UpdateSection(val section: String?) : Action()
    }

    fun apply(action: Action): PopupState = when (action) {
        is Action.Move -> copy(section = action.section, id = action.id)
        is Action.UpdateSection -> copy(previousSection = action.section)
    }

    val popupId = "$section/$id"
}


val popup by functionalComponent<PopupProps> { props ->

    val (state, dispatch) = useReducer(PopupState::apply, PopupState(props.section, props.id, props.section))

    val show = props.section != null && props.id != null

    val transitionState = useTransition(show, 350)

    if (show && (state.section != props.section || props.id != state.id)) {
        dispatch(PopupState.Action.Move(props.section, props.id))
    }

    if (props.id == null && state.previousSection != props.section) {
        dispatch(PopupState.Action.UpdateSection(props.section.coerceToNull()))
    }

    fchild(overlay{
        this.id = state.popupId
        this.onCloseSection = state.previousSection ?: ""
        this.transitionState = transitionState
    }) {

        if (state.id != null) {
            when (state.section) {
                "speakers" -> {
                    fchild(speaker {
                        this.id = state.id
                    })
                }
                "agenda" -> {
                    fchild(talk {
                        this.id = state.id
                    })
                }
            }
        }
    }

}
