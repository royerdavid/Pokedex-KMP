package royerdavid.pokedex.core.presentation

import org.jetbrains.compose.resources.getString
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.error_connection_timeout
import pokedex.composeapp.generated.resources.error_http400
import pokedex.composeapp.generated.resources.error_http401
import pokedex.composeapp.generated.resources.error_http403
import pokedex.composeapp.generated.resources.error_http404
import pokedex.composeapp.generated.resources.error_http500
import pokedex.composeapp.generated.resources.error_http502
import pokedex.composeapp.generated.resources.error_http503
import pokedex.composeapp.generated.resources.error_request_timeout
import pokedex.composeapp.generated.resources.error_serialization
import pokedex.composeapp.generated.resources.error_socket_timeout
import pokedex.composeapp.generated.resources.error_unknown
import pokedex.composeapp.generated.resources.error_unknown_x
import royerdavid.pokedex.core.data.ApiError

suspend fun ApiError.getString(): String {
    return when (this) {
        is ApiError.ConnectTimeout -> getString(Res.string.error_connection_timeout)
        is ApiError.RequestTimeout -> getString(Res.string.error_request_timeout)
        is ApiError.Serialization -> getString(Res.string.error_serialization)
        is ApiError.SocketTimeout -> getString(Res.string.error_socket_timeout)
        is ApiError.Unknown -> getString(Res.string.error_unknown)
        is ApiError.HttpResponse -> {
            when (this.code) {
                400 -> getString(Res.string.error_http400)
                401 -> getString(Res.string.error_http401)
                403 -> getString(Res.string.error_http403)
                404 -> getString(Res.string.error_http404)
                500 -> getString(Res.string.error_http500)
                502 -> getString(Res.string.error_http502)
                503 -> getString(Res.string.error_http503)
                else -> getString(Res.string.error_unknown_x, code)
            }
        }
    }
}
