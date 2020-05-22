package serviceWorker

import org.khronos.webgl.ArrayBuffer
import org.w3c.files.Blob
import org.w3c.workers.ExtendableEvent
import org.w3c.workers.ExtendableEventInit

/**
 * Exposes the JavaScript [PushEvent](https://developer.mozilla.org/en-US/docs/Web/API/PushEvent) to Kotlin
 */
open external class PushEvent(type: String, eventInitDict: ExtendableEventInit = definedExternally) : ExtendableEvent {
    val data: PushMessageData
}

external interface PushMessageData {
    fun arrayBuffer(): ArrayBuffer
    fun blob(): Blob
    fun json(): JSON
    fun text(): String
}
