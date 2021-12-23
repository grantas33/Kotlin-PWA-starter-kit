package client

import client.components.loadingComponent
import io.github.grantas33.kotlinpwacomponents.PushManagerState
import io.github.grantas33.kotlinpwacomponents.ServiceWorkerState
import io.github.grantas33.kotlinpwacomponents.usePushManager
import io.github.grantas33.kotlinpwacomponents.useServiceWorker
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*

val scope = MainScope()

val App = fc<Props> {

    val serviceWorkerState = useServiceWorker()
    val (pushManagerState, subscribeUser, unsubscribeUser) = usePushManager(
        serviceWorkerState = serviceWorkerState,
        publicKey = "BLceSSynHW5gDWDz-SK5mmQgUSAOzs_yXMPtDO0AmNsRjUllTZsdmDU4_gKvTr_q1hA8ZX19xLbGe28Bkyvwm3E"
    )

    when (serviceWorkerState) {
        is ServiceWorkerState.Registered -> {
            h1 {
                +"Successfully registered a service worker!"
            }
            when (pushManagerState) {
                is PushManagerState.NotSubscribed -> {
                    button {
                        attrs {
                            onClickFunction = {
                                scope.launch {
                                    subscribeUser(pushManagerState) {
                                        console.log("Sending subscription to server...")
                                    }
                                }
                            }
                        }
                        +"Click here to subscribe to push notifications"
                    }
                }
                is PushManagerState.Subscribed -> {
                    h2 {
                        +"User is subscribed to Push API"
                    }
                    button {
                        attrs {
                            onClickFunction = {
                                scope.launch {
                                    unsubscribeUser(pushManagerState)
                                }
                            }
                        }
                        +"Click here to unsubscribe"
                    }
                }
                PushManagerState.NotSupported -> h2 {
                    +"Push API is not supported on this browser"
                }
                PushManagerState.Loading, PushManagerState.NotLoaded -> loadingComponent()
            }
        }
        is ServiceWorkerState.Failed -> h1 {
            +"Error in registering service worker: ${serviceWorkerState.exception.message}"
        }
        ServiceWorkerState.Loading -> loadingComponent()
    }
}

fun RBuilder.App(props: Props,handler:RHandler<Props>) = child(App,props,handler)