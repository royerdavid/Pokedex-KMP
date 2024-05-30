import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module


private const val API_BASE_URL = "https://s3.amazonaws.com/sq-mobile-interview/"

val commonModule = module {
    single {
        HttpClient {
            expectSuccess = true

            defaultRequest {
                url(API_BASE_URL)
            }

            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }
}
