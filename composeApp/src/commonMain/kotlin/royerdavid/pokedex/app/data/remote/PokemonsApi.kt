package royerdavid.pokedex.app.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import royerdavid.pokedex.app.data.remote.HttpRoutes.POKEMONS
import royerdavid.pokedex.app.data.remote.dto.PokemonsRootDto

class PokemonsApi(private val httpClient: HttpClient) {

    suspend fun getPokemons(): Result<PokemonsRootDto> = runCatching {
        httpClient.get(POKEMONS) {
            url {
                parameters.append("limit", "99999")
            }
            contentType(ContentType.Application.Json)
        }.body()
    }
}
