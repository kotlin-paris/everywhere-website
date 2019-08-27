package paris.kotlin.everywhere.mainpage

import kotlinx.css.*
import paris.kotlin.everywhere.data.speakers
import paris.kotlin.everywhere.data.talks
import paris.kotlin.everywhere.utils.getValue
import react.*
import react.dom.*
import styled.css
import styled.styledDiv


interface SpeakerProps : RProps {
    var id: String
}

val speaker by functionalComponent<SpeakerProps> {
    val speaker = speakers[it.id] ?: return@functionalComponent

    styledDiv {
        css {
            display = Display.flex
            flexDirection = FlexDirection.column
            justifyContent = JustifyContent.center
            alignItems = Align.center

            "img" {
                borderRadius = 10.px
                marginBottom = 0.5.em
            }

            "h3" {
                fontSize = 1.5.em
                textAlign = TextAlign.center
            }
            "h4" {
                fontWeight = FontWeight.normal
            }

            "p.links" {
                paddingTop = 0.5.em

                "img" {
                    height = 2.em
                    marginBottom = 0.em
                    padding(0.em, 1.em)
                }
            }

            "p.text" {
                paddingTop = 0.8.em
                alignSelf = Align.stretch
                fontSize = 0.9.em
            }

            "hr" {
                alignSelf = Align.stretch
                backgroundColor = Color.silver
                height = 1.px
                borderStyle = BorderStyle.none
                margin(0.8.em, 0.em)
            }

            "p.talks" {
                display = Display.block
                alignSelf = Align.flexStart

                "a" {
                    display = Display.block
                    marginBottom = 0.75.em
                }
            }
        }

        img(src = "speakers/${speaker.id}.jpg") {}
        h3 { +speaker.name }
        speaker.company?.let { h4 { +it } }
        if (speaker.twitter != null || speaker.webSite != null) {
            p("links") {
                speaker.twitter?.let {
                    a(href = "https://twitter.com/$it", target = "_blank") { img(src = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n<svg\n   xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n   xmlns:cc=\"http://creativecommons.org/ns#\"\n   xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n   xmlns:svg=\"http://www.w3.org/2000/svg\"\n   xmlns=\"http://www.w3.org/2000/svg\"\n   version=\"1.1\"\n   id=\"svg3626\"\n   viewBox=\"0 0 300.00006 244.18703\"\n   height=\"244.18703\"\n   width=\"300.00006\">\n  <defs\n     id=\"defs3628\" />\n  <metadata\n     id=\"metadata3631\">\n    <rdf:RDF>\n      <cc:Work\n         rdf:about=\"\">\n        <dc:format>image/svg+xml</dc:format>\n        <dc:type\n           rdf:resource=\"http://purl.org/dc/dcmitype/StillImage\" />\n        <dc:title></dc:title>\n      </cc:Work>\n    </rdf:RDF>\n  </metadata>\n  <g\n     transform=\"translate(-539.17946,-568.85777)\"\n     id=\"layer1\">\n    <path\n       id=\"path3611\"\n       style=\"fill:#1da1f2;fill-opacity:1;fill-rule:nonzero;stroke:none\"\n       d=\"m 633.89823,812.04479 c 112.46038,0 173.95627,-93.16765 173.95627,-173.95625 0,-2.64628 -0.0539,-5.28062 -0.1726,-7.90305 11.93799,-8.63016 22.31446,-19.39999 30.49762,-31.65984 -10.95459,4.86937 -22.74358,8.14741 -35.11071,9.62551 12.62341,-7.56929 22.31446,-19.54304 26.88583,-33.81739 -11.81284,7.00307 -24.89517,12.09297 -38.82383,14.84055 -11.15723,-11.88436 -27.04079,-19.31655 -44.62892,-19.31655 -33.76374,0 -61.14426,27.38052 -61.14426,61.13233 0,4.79784 0.5364,9.46458 1.58538,13.94057 -50.81546,-2.55686 -95.87353,-26.88582 -126.02546,-63.87991 -5.25082,9.03545 -8.27852,19.53111 -8.27852,30.73006 0,21.21186 10.79366,39.93837 27.20766,50.89296 -10.03077,-0.30992 -19.45363,-3.06348 -27.69044,-7.64676 -0.009,0.25652 -0.009,0.50661 -0.009,0.78077 0,29.60957 21.07478,54.3319 49.0513,59.93435 -5.13757,1.40062 -10.54335,2.15158 -16.12196,2.15158 -3.93364,0 -7.76596,-0.38716 -11.49099,-1.1026 7.78383,24.2932 30.35457,41.97073 57.11525,42.46543 -20.92578,16.40207 -47.28712,26.17062 -75.93712,26.17062 -4.92898,0 -9.79834,-0.28036 -14.58427,-0.84634 27.05868,17.34379 59.18936,27.46396 93.72193,27.46396\" />\n  </g>\n</svg>\n") {} }
                }
                speaker.webSite?.let {
                    a(href = it, target = "_blank") { img(src = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n<!-- Generator: Adobe Illustrator 16.0.0, SVG Export Plug-In . SVG Version: 6.00 Build 0)  -->\n\n<svg\n   xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n   xmlns:cc=\"http://creativecommons.org/ns#\"\n   xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n   xmlns:svg=\"http://www.w3.org/2000/svg\"\n   xmlns=\"http://www.w3.org/2000/svg\"\n   xmlns:sodipodi=\"http://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd\"\n   xmlns:inkscape=\"http://www.inkscape.org/namespaces/inkscape\"\n   version=\"1.1\"\n   id=\"Capa_1\"\n   x=\"0px\"\n   y=\"0px\"\n   width=\"457.03px\"\n   height=\"457.03px\"\n   viewBox=\"0 0 457.03 457.03\"\n   style=\"enable-background:new 0 0 457.03 457.03;\"\n   xml:space=\"preserve\"\n   sodipodi:docname=\"link.svg\"\n   inkscape:version=\"0.92.4 (5da689c313, 2019-01-14)\"><metadata\n   id=\"metadata41\"><rdf:RDF><cc:Work\n       rdf:about=\"\"><dc:format>image/svg+xml</dc:format><dc:type\n         rdf:resource=\"http://purl.org/dc/dcmitype/StillImage\" /></cc:Work></rdf:RDF></metadata><defs\n   id=\"defs39\" /><sodipodi:namedview\n   pagecolor=\"#ffffff\"\n   bordercolor=\"#666666\"\n   borderopacity=\"1\"\n   objecttolerance=\"10\"\n   gridtolerance=\"10\"\n   guidetolerance=\"10\"\n   inkscape:pageopacity=\"0\"\n   inkscape:pageshadow=\"2\"\n   inkscape:window-width=\"2496\"\n   inkscape:window-height=\"1376\"\n   id=\"namedview37\"\n   showgrid=\"false\"\n   inkscape:zoom=\"0.51637748\"\n   inkscape:cx=\"232.38813\"\n   inkscape:cy=\"219.80044\"\n   inkscape:window-x=\"2112\"\n   inkscape:window-y=\"27\"\n   inkscape:window-maximized=\"1\"\n   inkscape:current-layer=\"g4\" />\n<g\n   id=\"g4\">\n\t<path\n   d=\"M421.512,207.074l-85.795,85.767c-47.352,47.38-124.169,47.38-171.529,0c-7.46-7.439-13.296-15.821-18.421-24.465   l39.864-39.861c1.895-1.911,4.235-3.006,6.471-4.296c2.756,9.416,7.567,18.33,14.972,25.736c23.648,23.667,62.128,23.634,85.762,0   l85.768-85.765c23.666-23.664,23.666-62.135,0-85.781c-23.635-23.646-62.105-23.646-85.768,0l-30.499,30.532   c-24.75-9.637-51.415-12.228-77.373-8.424l64.991-64.989c47.38-47.371,124.177-47.371,171.557,0   C468.869,82.897,468.869,159.706,421.512,207.074z M194.708,348.104l-30.521,30.532c-23.646,23.634-62.128,23.634-85.778,0   c-23.648-23.667-23.648-62.138,0-85.795l85.778-85.767c23.665-23.662,62.121-23.662,85.767,0   c7.388,7.39,12.204,16.302,14.986,25.706c2.249-1.307,4.56-2.369,6.454-4.266l39.861-39.845   c-5.092-8.678-10.958-17.03-18.421-24.477c-47.348-47.371-124.172-47.371-171.543,0L35.526,249.96   c-47.366,47.385-47.366,124.172,0,171.553c47.371,47.356,124.177,47.356,171.547,0l65.008-65.003   C246.109,360.336,219.437,357.723,194.708,348.104z\"\n   id=\"path2\"\n   style=\"fill:#7f7f7f;fill-opacity:1\" />\n</g>\n<g\n   id=\"g6\">\n</g>\n<g\n   id=\"g8\">\n</g>\n<g\n   id=\"g10\">\n</g>\n<g\n   id=\"g12\">\n</g>\n<g\n   id=\"g14\">\n</g>\n<g\n   id=\"g16\">\n</g>\n<g\n   id=\"g18\">\n</g>\n<g\n   id=\"g20\">\n</g>\n<g\n   id=\"g22\">\n</g>\n<g\n   id=\"g24\">\n</g>\n<g\n   id=\"g26\">\n</g>\n<g\n   id=\"g28\">\n</g>\n<g\n   id=\"g30\">\n</g>\n<g\n   id=\"g32\">\n</g>\n<g\n   id=\"g34\">\n</g>\n</svg>") {} }
                }
            }
        }
        p("text") { +speaker.description }

        hr {}

        p("talks") {
            speaker.talks.mapNotNull { talks[it] }.forEach { talk ->
                a(href = "#/agenda/${talk.id}") {
                    b {
                        talk.type.prefix?.let { +it }
                        +talk.title
                    }
                }
            }
        }
    }

}
