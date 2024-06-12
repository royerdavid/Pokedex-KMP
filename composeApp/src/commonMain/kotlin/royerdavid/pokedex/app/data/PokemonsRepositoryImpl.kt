package royerdavid.pokedex.app.data


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import royerdavid.pokedex.app.data.local.PokemonsDao
import royerdavid.pokedex.app.data.mappers.toEntity
import royerdavid.pokedex.app.data.mappers.toModel
import royerdavid.pokedex.app.data.remote.PokemonsApi
import royerdavid.pokedex.app.domain.PokemonsRepository
import royerdavid.pokedex.app.domain.model.PokemonSummary
import royerdavid.pokedex.core.data.DataError
import royerdavid.pokedex.core.data.DataResult
import royerdavid.pokedex.core.data.toDataError
import royerdavid.pokedex.core.util.Logger
import kotlin.coroutines.cancellation.CancellationException


/**
 * Repository to handle pokemon data
 */
class PokemonsRepositoryImpl(
    private val api: PokemonsApi,
    private val dao: PokemonsDao,
    private val logger: Logger
) : PokemonsRepository {

    companion object {
        private const val LOG_TAG = "PokemonsRepo"
    }

    override suspend fun getPokemonSummaries(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<DataResult<List<PokemonSummary>, DataError>> {
        return flow {
            emit(DataResult.Loading(true))

            // Get listing from cache
            val localListings = dao.searchPokemonSummaries(query)
            emit(
                DataResult.Success(
                    data = localListings.map { it.toModel() }
                ))

            // Quick exit when we have listing from cache and no remote fetch
            val isCacheEmpty = localListings.isEmpty() && query.isBlank()
            val fromCacheOnly = !isCacheEmpty && !fetchFromRemote
            if (fromCacheOnly) {
                emit(DataResult.Loading(false))
                return@flow
            }

            // Get remote listing
            var dataError: DataError? = null

            val remoteListings = try {
                api.getPokemonSummaries().results
            } catch (e: CancellationException) {
                logger.d(tag = LOG_TAG, message = "Rethrowing CancellationException")
                throw e
            } catch (e: Exception) {
                dataError = e.toDataError()
                null
            }

            if (dataError == null) {
                // Update cache with remote listing & return updated listing
                remoteListings?.let { listings ->
                    dao.clearPokemonSummaries()
                    dao.insertPokemonSummaries(
                        listings.map { it.toEntity() }
                    )
                    emit(
                        DataResult.Success(
                            data = dao
                                .searchPokemonSummaries("")
                                .map { it.toModel() }
                        ))
                }
            } else {
                // Propagate the error
                emit(DataResult.Error(dataError))
            }

            emit(DataResult.Loading(false))
        }
    }
}
