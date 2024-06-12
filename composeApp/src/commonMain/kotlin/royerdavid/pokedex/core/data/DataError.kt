package royerdavid.pokedex.core.data

import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.ResponseException
import io.ktor.utils.io.errors.IOException
import kotlinx.serialization.SerializationException

/**
 * Errors exposed from the data layer to the other layers
 */
sealed class DataError(open val debugMessage: String, open val exception: Exception?) {

    data class ConnectTimeout(
        override val debugMessage: String,
        override val exception: Exception? = null
    ) : DataError(debugMessage, exception)

    data class NoConnection(
        override val debugMessage: String,
        override val exception: Exception? = null
    ) : DataError(debugMessage, exception)

    data class RequestTimeout(
        override val debugMessage: String,
        override val exception: Exception? = null
    ) : DataError(debugMessage, exception)

    data class Serialization(
        override val debugMessage: String,
        override val exception: Exception? = null
    ) : DataError(debugMessage, exception)

    data class SocketTimeout(
        override val debugMessage: String,
        override val exception: Exception? = null
    ) : DataError(debugMessage, exception)

    data class Unknown(
        override val debugMessage: String,
        override val exception: Exception? = null
    ) : DataError(debugMessage, exception)

    data class HttpResponse(
        override val debugMessage: String,
        override val exception: Exception? = null,
        val code: Int
    ) : DataError(debugMessage, exception)
}

internal fun Exception.toDataError(): DataError {
    return when (this) {
        is ResponseException -> {
            DataError.HttpResponse(
                debugMessage = message ?: "HTTP error ${response.status.value}",
                exception = this,
                code = response.status.value
            )
        }

        is IllegalArgumentException -> {
            if (cause is SerializationException) {
                DataError.Serialization(message ?: this.toString(), this)
            } else {
                DataError.Unknown(message ?: this.toString(), this)
            }
        }

        is ConnectTimeoutException ->
            DataError.ConnectTimeout(message ?: this.toString(), this)

        is HttpRequestTimeoutException ->
            DataError.RequestTimeout(message ?: this.toString(), this)

        is SocketTimeoutException ->
            DataError.SocketTimeout(message ?: this.toString(), this)

        is IOException ->
            DataError.NoConnection(message ?: this.toString(), this)

        else ->
            DataError.Unknown(message ?: this.toString(), this)
    }
}
