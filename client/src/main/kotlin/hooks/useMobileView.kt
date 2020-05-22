package client.hooks

import react.*
import kotlin.browser.window

fun useMobileView(): Boolean {
    fun isMobileView(): Boolean = window.innerWidth <= 768

    val (isMobileView, setMobileView) = useState(isMobileView())

    useEffectWithCleanup (dependencies = listOf()) {
        fun handleDimensionsChange(): Unit = setMobileView(isMobileView())
        window.addEventListener("resize", { handleDimensionsChange() })
        return@useEffectWithCleanup { window.removeEventListener("resize", { handleDimensionsChange() }) }
    }
    return isMobileView
}