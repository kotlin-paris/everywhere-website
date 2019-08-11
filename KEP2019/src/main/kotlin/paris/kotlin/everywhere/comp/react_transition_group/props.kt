package paris.kotlin.everywhere.comp.react_transition_group

import react.RProps

interface TransitionProps : RProps {
    var `in`: Boolean
    var timeout: Int
    var mountOnEnter: Boolean
    var unmountOnExit: Boolean
    var appear: Boolean
}
