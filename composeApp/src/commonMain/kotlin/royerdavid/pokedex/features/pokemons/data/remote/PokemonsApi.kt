package royerdavid.pokedex.features.pokemons.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import royerdavid.pokedex.features.pokemons.data.remote.dto.PokemonsRootDto

class PokemonsApi(private val ktorClient: HttpClient) {

    suspend fun getPokemons(): Result<PokemonsRootDto> = runCatching {
        ktorClient.get("cards") {
            url {
                parameters.append("pageSize", "128")
                parameters.append("orderBy", "name")
                parameters.append("select", "id,name,types,images")
            }
        }.body()
    }
}
