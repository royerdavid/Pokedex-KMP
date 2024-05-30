package royerdavid.pokedex.features.employees.data


import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import royerdavid.pokedex.core.util.Resource
import royerdavid.pokedex.features.employees.data.local.PokemonsDao
import royerdavid.pokedex.features.employees.data.remote.PokemonsApi
import royerdavid.pokedex.features.employees.domain.PokemonsRepository
import royerdavid.pokedex.features.employees.domain.model.Pokemon

/**
 * Repository to handle employees data
 */
class PokemonsRepositoryImpl(
    private val api: PokemonsApi,
    private val dao: PokemonsDao
) : PokemonsRepository {

    override suspend fun getEmployees(): Flow<Resource<List<Pokemon>>> = flow {
        emit(Resource.Loading())
        val cachedEmployeeList = dao.getAll().map { it.toPokemon() }
        emit(Resource.Loading(cachedEmployeeList))

        try {
            val remoteEmployeeList =
                api.getEmployees().getOrNull()?.employees // todo hacky to go quickly

            if (remoteEmployeeList != null) {
                dao.insertAll(remoteEmployeeList.map { it.toEmployeeEntity() })
            }
        } catch (e: IOException) {
            //emit(Resource.Error(e))
            emit(Resource.Error(e, cachedEmployeeList))
        }

        // TODO: Optimise logic. The current one always give a success
        // Newly inserted items
        val newEmployeeList = dao.getAll().map { it.toPokemon() }
        emit(Resource.Success(newEmployeeList))
    }

    override suspend fun getEmployee(id: String): Flow<Resource<Pokemon>> = flow {
        // TODO handle non-happy paths like missing employee entry
        //     val cachedEmployee = dao.getById(id).toEmployee()
        //     emit(Resource.Success(cachedEmployee))
    }
}
