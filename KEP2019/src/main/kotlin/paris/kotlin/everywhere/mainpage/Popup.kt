package paris.kotlin.everywhere.mainpage

import paris.kotlin.everywhere.MainPage
import paris.kotlin.everywhere.comp.react_transition_group.Transition
import react.*

class Popup : RComponent<Popup.Props, Popup.State>() {

    interface Props : RProps {
        var section: String?
        var id: String?
    }

    interface State : RState {
        var previousSection: String?
        var lastProps: Popup.Props?
    }

    override fun RBuilder.render() {
        Transition {

            attrs {
                `in` = props.section != null && props.id != null
                timeout = 350
                appear = true
            }

            val p = props.takeIf { it.id != null } ?: state.lastProps ?: props

            childList += { transitionState: String -> buildElement {
                child(Overlay::class) {
                    attrs {
                        this.id = "${p.section}/${p.id}"
                        this.onCloseSection = state.previousSection ?: ""
                        this.transitionState = transitionState
                    }

                    when (p.section) {
                        "speakers" -> {
                            child(Speaker::class) {
                                attrs {
                                    id = p.id!!
                                }
                            }
                        }
                        "agenda" -> {
                            child(Talk::class) {
                                attrs {
                                    id = p.id!!
                                }
                            }
                        }
                    }
                }

            } }

        }
    }

    override fun UNSAFE_componentWillReceiveProps(nextProps: Popup.Props) {
        if (props.id == null) {
            setState {
                previousSection = props.section
            }
        }

        setState { lastProps = props }
    }

}
