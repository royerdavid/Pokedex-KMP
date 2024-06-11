package royerdavid.pokedex.app.data


import io.ktor.client.plugins.ResponseException
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import royerdavid.pokedex.app.data.local.PokemonsDao
import royerdavid.pokedex.app.data.mappers.toEntity
import royerdavid.pokedex.app.data.mappers.toModel
import royerdavid.pokedex.app.data.remote.PokemonsApi
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

    /**
     * Loading = true
     * Return data from from DB
     *
     *
     */
    override suspend fun getPokemonSummaries(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<PokemonSummary>>> {
        return flow {
            emit(Resource.Loading(true))

            // Get listing from cache
            val localListings = dao.searchPokemonSummaries(query)
            emit(Resource.Success(
                data = localListings.map { it.toModel() }
            ))

            // Quick exit when we have listing from cache and no remote fetch
            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            // Get remote listing
            val remoteListings = try {
                api.getPokemonSummaries().results
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(e))
                emit(Resource.Loading(false))
                null
            } catch (e: ResponseException) {
                e.printStackTrace()
                emit(Resource.Error(e))
                emit(Resource.Loading(false))
                null
            }

            // Update cache with remote listing & return updated listing
            remoteListings?.let { listings ->
                dao.clearPokemonSummaries()
                dao.insertPokemonSummaries(
                    listings.map { it.toEntity() }
                )
                emit(Resource.Success(
                    data = dao
                        .searchPokemonSummaries("")
                        .map { it.toModel() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }
}
