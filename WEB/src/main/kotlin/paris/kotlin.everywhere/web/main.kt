package paris.kotlin.everywhere.web

import paris.kotlin.everywhere.MainPage
import paris.kotlin.everywhere.app
import react.dom.hydrate
import react.dom.render
import react.router.dom.hashRouter
import react.router.dom.route
import kotlin.browser.document

fun main() {
    hydrate(document.getElementById("app")) {
        hashRouter {
            route<MainPage.Props>("/:section?/:id?") {
                val params = it.match.params
                params.isStatic = false
                app(params)
            }
        }
    }
}
