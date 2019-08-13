package paris.kotlin.everywhere.web

import paris.kotlin.everywhere.AppProps
import paris.kotlin.everywhere.app
import paris.kotlin.everywhere.utils.fchild
import paris.kotlin.everywhere.utils.plus
import paris.kotlin.everywhere.webApp
import react.dom.hydrate
import react.router.dom.hashRouter
import react.router.dom.route
import kotlin.browser.document

fun main() {
    hydrate(document.getElementById("app")) {
        fchild(webApp)
    }
}
