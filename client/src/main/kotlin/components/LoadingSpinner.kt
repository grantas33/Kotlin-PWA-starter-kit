@file:JsModule("react-loader-spinner")
@file:JsNonModule

package client.components

import react.*

@JsName("default")
external val LoadingSpinner: ComponentClass<LoadingSpinnerProps>

external interface LoadingSpinnerProps : Props {
    var type: String
    var color: String
    var height: Int
    var width: Int
    var timeout: Int
}