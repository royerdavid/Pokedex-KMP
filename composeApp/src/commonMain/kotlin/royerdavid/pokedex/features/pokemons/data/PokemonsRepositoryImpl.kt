package royerdavid.pokedex.features.pokemons.data


import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import royerdavid.pokedex.core.util.Resource
import royerdavid.pokedex.features.pokemons.data.local.PokemonsDao
import royerdavid.pokedex.features.pokemons.data.remote.PokemonsApi
import royerdavid.pokedex.features.pokemons.data.remote.dto.toPokemonEntity
import royerdavid.pokedex.features.pokemons.domain.PokemonsRepository
import royerdavid.pokedex.features.pokemons.domain.model.Pokemon

/**
 * Repository to handle pokemon data
 */
class PokemonsRepositoryImpl(
    private val api: PokemonsApi,
    private val dao: PokemonsDao
) : PokemonsRepository {

    override suspend fun getPokemons(): Flow<Resource<List<Pokemon>>> = flow {
        emit(Resource.Loading())
        val cachedPokemonList = dao.getAll().map { it.toPokemon() }
        emit(Resource.Loading(cachedPokemonList))

        try {
            val remotePokemonList = api.getPokemons().getOrThrow().data
            dao.insertAll(remotePokemonList
                .distinctBy { it.name }
                .map { it.toPokemonEntity() }
            )
        } catch (e: IOException) {
            emit(Resource.Error(e, cachedPokemonList))
        }

        // Newly inserted items
        val newPokemonList = dao.getAll().map { it.toPokemon() }
        emit(Resource.Success(newPokemonList))
    }
}
