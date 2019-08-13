package paris.kotlin.everywhere

import paris.kotlin.everywhere.utils.fchild
import paris.kotlin.everywhere.utils.getValue
import paris.kotlin.everywhere.utils.plus
import react.RProps
import react.functionalComponent
import react.router.dom.hashRouter
import react.router.dom.route


val webApp by functionalComponent<RProps> {
    hashRouter {
        route<AppProps>("/:section?/:id?") {
            val props = it.match.params
            props.isStatic = false
            fchild(app + props)
        }
    }
}
