package royerdavid.pokedex.features.pokemons.domain

import kotlinx.coroutines.flow.Flow
import royerdavid.pokedex.core.util.Resource
import royerdavid.pokedex.features.pokemons.domain.model.Pokemon

interface PokemonsRepository {
    suspend fun getPokemons(): Flow<Resource<List<Pokemon>>>
}
