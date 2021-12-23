package client

import kotlinext.js.jso
import react.dom.render
import kotlinx.browser.document

fun main() {
    document.getElementById("root")?.let {
        render(it) {
            App(props = jso(), handler = {})
        }
    }
}
