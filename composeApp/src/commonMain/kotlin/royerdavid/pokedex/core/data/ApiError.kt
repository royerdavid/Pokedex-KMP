package royerdavid.pokedex.core.data

import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.ResponseException
import kotlinx.serialization.SerializationException

/**
 * Errors exposed from the data layer to the other layers
 */
sealed class ApiError(open val debugMessage: String) {
    data class ConnectTimeout(override val debugMessage: String) : ApiError(debugMessage)
    data class RequestTimeout(override val debugMessage: String) : ApiError(debugMessage)
    data class HttpResponse(override val debugMessage: String, val code: Int) :
        ApiError(debugMessage)

    data class Serialization(override val debugMessage: String) : ApiError(debugMessage)
    data class SocketTimeout(override val debugMessage: String) : ApiError(debugMessage)
    data class Unknown(override val debugMessage: String) : ApiError(debugMessage)
}

internal fun Exception.toApiError(): ApiError {
    return when (this) {
        is ResponseException -> {
            ApiError.HttpResponse(
                debugMessage = message ?: "HTTP error ${response.status.value}",
                code = response.status.value
            )
        }

        is IllegalArgumentException -> {
            if (cause is SerializationException) {
                ApiError.Serialization(
                    message ?: "Unknown serialization exception"
                )
            } else {
                ApiError.Unknown(
                    message ?: "Unknown illegal argument exception"
                )
            }
        }

        is ConnectTimeoutException ->
            ApiError.ConnectTimeout(message ?: "Unknown connect timeout exception")

        is HttpRequestTimeoutException ->
            ApiError.RequestTimeout(message ?: "Unknown IO http request timeoutException")

        is SocketTimeoutException ->
            ApiError.SocketTimeout(message ?: "Unknown socket timeout exception")

        else -> ApiError.Unknown(message ?: "Unknown error")
    }
}