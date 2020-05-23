package client

import kotlinx.css.*
import react.child
import react.dom.render
import styled.StyledComponents
import styled.injectGlobal
import kotlin.browser.document

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

    StyledComponents.injectGlobal(styles.toString())

    render(document.getElementById("root")) {
        child(functionalComponent = App)
    }
}
