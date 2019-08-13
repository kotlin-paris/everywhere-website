package paris.kotlin.everywhere.web

import paris.kotlin.everywhere.utils.fchild
import paris.kotlin.everywhere.webApp
import react.dom.render
import kotlin.browser.document

fun main() {
    render(document.getElementById("app")) {
        fchild(webApp)
    }
}
