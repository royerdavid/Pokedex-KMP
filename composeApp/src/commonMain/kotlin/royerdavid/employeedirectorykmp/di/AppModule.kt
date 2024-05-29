package royerdavid.employeedirectorykmp.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

private const val BASE_URL = "https://s3.amazonaws.com/sq-mobile-interview/"


    // TODO
//    single {
//        ResourcesProvider(androidApplication())
//    }


val httpClientModule = module {
    single {
        // TODO Remove OkHttp as HttpClient parameter
        HttpClient {
            expectSuccess = true

            // TODO
//            engine {
//                addInterceptor(HttpLoggingInterceptor().apply {
//                    setLevel(HttpLoggingInterceptor.Level.BODY)
//                })
//            }

            defaultRequest {
                url(BASE_URL)
            }

            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }
}