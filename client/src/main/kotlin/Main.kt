package client

import kotlinext.js.jsObject
import kotlinx.css.*
import react.dom.render
import kotlinx.browser.document
import styled.injectGlobal

fun main() {
    val styles = CSSBuilder().apply {
        html {
            width = LinearDimension("100%")
            height = LinearDimension("100%")
        }
        body {
            margin = "0"
            padding = "0"
            width = LinearDimension("100%")
            height = LinearDimension("100%")
        }
        "#root" {
            width = LinearDimension("100%")
            height = LinearDimension("100%")
            textAlign = TextAlign.center
        }
    }

    injectGlobal(styles.toString())

    render(document.getElementById("root")) {
        App(props = jsObject(), handler = {})
    }
}
