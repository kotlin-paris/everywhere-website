package paris.kotlin.everywhere

import org.w3c.dom.*
import paris.kotlin.everywhere.mainpage.*
import paris.kotlin.everywhere.utils.fchild
import paris.kotlin.everywhere.utils.getValue
import paris.kotlin.everywhere.utils.invoke
import paris.kotlin.everywhere.utils.provideDelegate
import react.*
import kotlin.browser.window


interface HasAnchor {
    var scrollTo: RMutableRef<HTMLElement?>
}

val mainPage by functionalComponent<AppProps> {
    val anchors = listOf("agenda", "sponsors", "speakers", "talks", "contact").associateWith { useRef<HTMLElement?>(null) }

    fun getOffset(anchor: String?): Int {
        anchor ?: return 100
        val scrollTo = anchors[anchor]?.current ?: return -1
        return scrollTo.offsetTop - 60
    }

    useEffect(emptyList()) {
        if (it.section != null) {
            val offset = getOffset(it.section)
            if (offset != -1)
                window.scrollTo(ScrollToOptions(0.0, offset.toDouble(), ScrollBehavior.INSTANT))
        }
    }

    var previousSection by useState(it.section)
    var previousId by useState(it.id)
    useEffect(listOf(it.section, it.id)) {
        if (previousSection != it.section) {
            if (previousId == null && it.id == null) {
                val offset = getOffset(it.section)
                if (offset != -1)
                    window.scrollTo(ScrollToOptions(0.0, offset.toDouble(), ScrollBehavior.SMOOTH))
            }
        }
        previousSection = it.section
        previousId = it.id
    }

    fchild(popup {
        section = it.section
        id = it.id
    })

    fchild(header { isStatic = it.isStatic })

    fchild(subHeader { isStatic = it.isStatic })

    fchild(talkingPoints)

    fchild(workshops {
        scrollTo = anchors.getValue("agenda")
    })

    fchild(agenda)

    fchild(tickets)

    fchild(sponsors {
        scrollTo = anchors.getValue("sponsors")
    })

    fchild(speakers {
        scrollTo = anchors.getValue("speakers")
    })

    fchild(talks {
        scrollTo = anchors.getValue("talks")
    })

    fchild(tickets)

    fchild(contact {
        scrollTo = anchors.getValue("contact")
    })
}
