package client

import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Uint8Array
import org.w3c.workers.ServiceWorkerRegistration
import kotlin.js.Promise

sealed class ServiceWorkerState {
    data class Registered(val swRegistration: ServiceWorkerRegistration): ServiceWorkerState()
    data class Failed(val errorMessage: String?): ServiceWorkerState()
    object Loading: ServiceWorkerState()
}

sealed class PushManagerState {
    data class Subscribed(val pushManager: PushManager): PushManagerState()
    data class NotSubscribed(val pushManager: PushManager): PushManagerState()
    object Loading: PushManagerState()
    object NotSupported: PushManagerState()
}

data class PushSubscriptionOptions(val userVisibleOnly: Boolean, val applicationServerKey: Any)

external class PushSubscription {
    val endpoint: String
    val expirationTime: dynamic
    val options: PushSubscriptionOptions

    fun getKey(name: String): ArrayBuffer
    fun toJSON(): JSON
    fun unsubscribe(): Promise<Boolean>
}

inline val ServiceWorkerRegistration.pushManager: PushManager?
    get() = asDynamic().pushManager.unsafeCast<PushManager?>()

/**
 * Exposes the JavaScript [PushManager](https://developer.mozilla.org/en-US/docs/Web/API/PushManager) to Kotlin
 */
external interface PushManager {
    fun getSubscription(): Promise<PushSubscription?>
    fun permissionState(): Promise<String>
    fun subscribe(options: PushSubscriptionOptions): Promise<PushSubscription>
}
