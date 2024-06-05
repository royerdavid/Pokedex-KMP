package royerdavid.pokedex.app.domain

import kotlinx.coroutines.flow.Flow
import royerdavid.pokedex.app.domain.model.PokemonSummary
import royerdavid.pokedex.core.util.Resource

interface PokemonsRepository {
    suspend fun getPokemons(): Flow<Resource<List<PokemonSummary>>>
}
