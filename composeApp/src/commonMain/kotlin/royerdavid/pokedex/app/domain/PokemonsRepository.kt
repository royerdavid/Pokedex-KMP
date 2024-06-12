package royerdavid.pokedex.app.domain

import kotlinx.coroutines.flow.Flow
import royerdavid.pokedex.app.domain.model.PokemonSummary
import royerdavid.pokedex.core.data.DataError
import royerdavid.pokedex.core.data.DataResult

interface PokemonsRepository {
    suspend fun getPokemonSummaries(fetchFromRemote: Boolean, query: String = ""):
            Flow<DataResult<List<PokemonSummary>, DataError>>
}
