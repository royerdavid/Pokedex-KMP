package royerdavid.pokedex.features.employees.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import royerdavid.pokedex.features.employees.data.remote.dto.PokemonsRootDto


/**
 * API calls for `employees` endpoint
 */
class PokemonsApi(private val ktorClient: HttpClient) {

    suspend fun getEmployees(): Result<PokemonsRootDto> = runCatching {
        ktorClient.get("employees.json").body()
//        ktorClient.get("employees_malformed.json").body()
//        ktorClient.get("employees_empty.json").body()
    }
}
