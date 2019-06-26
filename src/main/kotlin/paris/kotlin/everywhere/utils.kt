package paris.kotlin.everywhere

import kotlinext.js.asJsObject
import kotlinext.js.getOwnPropertyNames

infix fun Any.copyInto(into: Any) {
    for (prop in this.asJsObject().getOwnPropertyNames())
        into.asDynamic()[prop] = this.asDynamic()[prop]
}
