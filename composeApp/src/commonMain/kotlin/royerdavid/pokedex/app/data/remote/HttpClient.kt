package royerdavid.pokedex.app.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import royerdavid.pokedex.core.util.Logger

private const val API_BASE_URL = "https://pokeapi.co/api/v2/"
private const val LOG_TAG = "HttpClient"

/**
 * Provide a HttpClient for dependency injection
 */
internal fun createHttpClient(logger: Logger) =
    HttpClient {
        expectSuccess = true

        defaultRequest {
            url(API_BASE_URL)
        }

        install(Logging) {
            this.logger = object : io.ktor.client.plugins.logging.Logger {
                override fun log(message: String) {
                    logger.d(tag = LOG_TAG, message = message)
                }
            }
            level = LogLevel.BODY
        }

        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
