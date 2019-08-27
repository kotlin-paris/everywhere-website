package paris.kotlin.everywhere.web

import paris.kotlin.everywhere.utils.fchild
import paris.kotlin.everywhere.webApp
import react.dom.hydrate
import kotlin.browser.document

fun main() {
    hydrate(document.getElementById("app")) {
        fchild(webApp)
    }
}
