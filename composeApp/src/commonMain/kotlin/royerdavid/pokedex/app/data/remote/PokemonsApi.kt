package royerdavid.pokedex.app.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import royerdavid.pokedex.app.data.remote.HttpRoutes.POKEMONS
import royerdavid.pokedex.app.data.remote.dto.PokemonsRootDto

class PokemonsApi(private val httpClient: HttpClient) {

    suspend fun getPokemonSummaries(): Result<PokemonsRootDto> = runCatching {
        httpClient.get(POKEMONS) {
            url {
                parameters.append("offset", "0")
                parameters.append("limit", "9999")
            }
        }.body()
    }
}
