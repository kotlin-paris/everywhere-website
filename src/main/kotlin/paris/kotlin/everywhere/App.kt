package paris.kotlin.everywhere

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.hashRouter
import react.router.dom.route

class App : RComponent<RProps, RState>() {

    override fun RBuilder.render() {

        hashRouter {
            route<MainPage.Props>("/:section?/:id?") {
                child(MainPage::class) {
                    attrs {
                        it.match.params copyInto this
                    }
                }
            }

        }
    }

}
