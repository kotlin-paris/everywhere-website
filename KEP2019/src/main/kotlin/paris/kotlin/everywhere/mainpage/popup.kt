package paris.kotlin.everywhere.mainpage

import paris.kotlin.everywhere.comp.react_transition_group.Transition
import paris.kotlin.everywhere.utils.*
import react.*
import react.dom.render
import kotlin.reflect.KFunction


interface PopupProps : RProps {
    var section: String?
    var id: String?
}

val popup by functionalComponent<PopupProps> {

    var section by useState(it.section)
    var id by useState(it.id)
    var previousSection by useState(it.section)

    val shown = it.section != null && it.id != null

    if (shown) {
        section = it.section
        id = it.id
    }

    if (it.id == null) {
        previousSection = it.section
    }

    Transition {

        attrs {
            `in` = shown
            timeout = 350
            appear = true
        }

        renderChild { transitionState: String ->
            fchild(overlay{
                this.id = "${section}/$id"
                this.onCloseSection = previousSection ?: ""
                this.transitionState = transitionState
            }) {

                if (id != null) {
                    when (section) {
                        "speakers" -> {
                            fchild(speaker {
                                this.id = id!!
                            })
                        }
                        "agenda" -> {
                            fchild(talk {
                                    this.id = id!!
                            })
                        }
                    }
                }
            }

        }

    }

}
