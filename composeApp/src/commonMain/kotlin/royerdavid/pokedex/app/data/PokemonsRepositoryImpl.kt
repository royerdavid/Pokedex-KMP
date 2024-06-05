package royerdavid.pokedex.app.data


import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import royerdavid.pokedex.app.data.local.PokemonsDao
import royerdavid.pokedex.app.data.remote.PokemonsApi
import royerdavid.pokedex.app.data.remote.dto.toPokemonEntity
import royerdavid.pokedex.app.domain.PokemonsRepository
import royerdavid.pokedex.app.domain.model.PokemonSummary
import royerdavid.pokedex.core.util.Resource

/**
 * Repository to handle pokemon data
 */
class PokemonsRepositoryImpl(
    private val api: PokemonsApi,
    private val dao: PokemonsDao
) : PokemonsRepository {

    override suspend fun getPokemons(): Flow<Resource<List<PokemonSummary>>> = flow {
        emit(Resource.Loading())
        val cachedPokemonList = dao.getAll().map { it.toPokemon() }
        emit(Resource.Loading(cachedPokemonList))

        try {
            val remotePokemonList = api.getPokemons().getOrThrow().results
            dao.insertAll(
                remotePokemonList.map {
                    it.toPokemonEntity()
                }
            )
        } catch (e: IOException) {
            emit(Resource.Error(e, cachedPokemonList))
        }

        // Newly inserted items
        val newPokemonList = dao.getAll().map { it.toPokemon() }
        emit(Resource.Success(newPokemonList))
    }
}
