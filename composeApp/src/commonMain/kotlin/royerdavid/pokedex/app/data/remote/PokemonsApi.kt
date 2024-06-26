package royerdavid.pokedex.app.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import royerdavid.pokedex.app.data.remote.ApiRoutes.POKEMONS
import royerdavid.pokedex.app.data.remote.dto.PokemonsRootDto

class PokemonsApi(private val httpClient: HttpClient) {

    suspend fun getPokemonSummaries(): PokemonsRootDto =
        httpClient.get(POKEMONS) {
            url {
                parameters.append("offset", "0")
                parameters.append("limit", "9999")
            }
        }.body()
}
