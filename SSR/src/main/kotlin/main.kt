import kotlinx.html.*
import kotlinx.html.stream.createHTML
import paris.kotlin.everywhere.app
import paris.kotlin.everywhere.utils.fchild
import paris.kotlin.everywhere.utils.invoke
import react.buildElement
import react_dom.server.renderToString
import styled_components.ServerStyleSheet

fun main() {
    val sheet = ServerStyleSheet()

    val appStr = renderToString(sheet.collectStyles(buildElement { fchild(app { isStatic = true }) }!!))

    val html = createHTML().html {
        lang = "fr"

        head {
            meta("viewport", "minimum-scale=1, initial-scale=1, width=device-width, shrink-to-fit=no")
            meta("description", "Type: Conférence, Sujet: Kotlin,  Date: 19 octobre 2019")

            link(href = "https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap", rel = "stylesheet")
            link(href = "favicon.png", rel = "icon", type = "image/png")

            title("Kotlin Everywhere Paris 2019")
            unsafe { raw(sheet.getStyleTags()) }
        }

        body {
            style = "margin: 0; padding: 0;"

            div {
                id = "app"
                unsafe { raw(appStr) }
            }

            script(type = "text/javascript", src = "WEB.js") {}
        }
    }

    println(html)

}
