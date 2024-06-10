package royerdavid.pokedex.app.data


import io.ktor.client.plugins.ResponseException
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import royerdavid.pokedex.app.data.local.PokemonsDao
import royerdavid.pokedex.app.data.mappers.toEntity
import royerdavid.pokedex.app.data.mappers.toModel
import royerdavid.pokedex.app.data.remote.PokemonsApi
import royerdavid.pokedex.app.data.remote.dto.NamedApiResourceDto
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

    override suspend fun getPokemonSummaries(): Flow<Resource<List<PokemonSummary>>> = flow {
        emit(Resource.Loading())
        val cachedPokemonList = dao.getAllPokemonSummaries().map { it.toModel() }
        emit(Resource.Loading(cachedPokemonList))

        var remotePokemonList: List<NamedApiResourceDto>? = null

        try {
            remotePokemonList = api.getPokemonSummaries().getOrThrow().results
        } catch (e: IOException) {
            emit(Resource.Error(e, cachedPokemonList))
        } catch (e: ResponseException) {
            emit(Resource.Error(e, cachedPokemonList))
        }

        if (!remotePokemonList.isNullOrEmpty()) {
            dao.insertAll(
                remotePokemonList.map {
                    it.toEntity()
                }
            )
        }

        // Newly inserted items
        val newPokemonList = dao.getAllPokemonSummaries().map {
            it.toModel()
        }
        emit(Resource.Success(newPokemonList))
    }
}
