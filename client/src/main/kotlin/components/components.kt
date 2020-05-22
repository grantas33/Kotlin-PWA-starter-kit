package client.components

import kotlinx.css.*
import kotlinx.html.DIV
import react.RBuilder
import react.dom.RDOMBuilder
import styled.css
import styled.styledDiv

fun RBuilder.flexBox(block: RDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        display = Display.flex
        justifyContent = JustifyContent.center
        alignItems = Align.center
        minWidth = LinearDimension("100%")
        minHeight = LinearDimension("100%")
        flexDirection = FlexDirection.column
    }
    block()
}

fun RBuilder.loadingComponent() = LoadingSpinner {
    attrs {
        type="MutatingDots"
        color="green"
        height=100
        width=100
    }
}

fun CSSBuilder.mobileView(block: RuleSet) {
    media("(max-width: 768px)") {
        block()
    }
}



