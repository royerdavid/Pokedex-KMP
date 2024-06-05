package royerdavid.pokedex.features.pokemons.domain

import kotlinx.coroutines.flow.Flow
import royerdavid.pokedex.core.util.Resource
import royerdavid.pokedex.features.pokemons.domain.model.PokemonSummary

interface PokemonsRepository {
    suspend fun getPokemons(): Flow<Resource<List<PokemonSummary>>>
}
