@file:JsModule("styled-components")
package styled_components

import react.ReactElement

external class ServerStyleSheet {
    fun collectStyles(element: ReactElement): ReactElement
    fun getStyleTags(): String
}
