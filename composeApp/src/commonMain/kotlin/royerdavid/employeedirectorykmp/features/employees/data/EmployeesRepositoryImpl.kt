package royerdavid.employeedirectorykmp.features.employees.data


import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import royerdavid.employeedirectorykmp.core.util.Resource
import royerdavid.employeedirectorykmp.features.employees.data.remote.EmployeesApi
import royerdavid.employeedirectorykmp.features.employees.domain.EmployeesRepository
import royerdavid.employeedirectorykmp.features.employees.domain.model.Employee

/**
 * Repository to handle employees data
 */
class EmployeesRepositoryImpl(
    private val api: EmployeesApi,
    //private val dao: EmployeesDao
) : EmployeesRepository {

    override suspend fun getEmployees(): Flow<Resource<List<Employee>>> = flow {
        emit(Resource.Loading())
//       // val cachedEmployeeList = dao.getAll().map { it.toEmployee() }
//        emit(Resource.Loading(cachedEmployeeList))
//
        try {
            val remoteEmployeeList = api.getEmployees().getOrNull()?.employees // todo hacky to go quickly



            if (remoteEmployeeList != null) {
//                dao.insertAll(remoteEmployeeList.map { it.toEmployeeEntity() })

                // TODO temp
                val newEmployeeList = remoteEmployeeList.map { it.toEmployee() }
                emit(Resource.Success(newEmployeeList))
            }
        } catch (e: IOException) {
            emit(Resource.Error(e))
//            emit(Resource.Error(e, cachedEmployeeList))
        }

        // TODO: Optimise logic. The current one always give a success
        // Newly inserted items
        //  val newEmployeeList = dao.getAll().map { it.toEmployee() }
//        emit(Resource.Success(newEmployeeList))
    }

    override suspend fun getEmployee(id: String): Flow<Resource<Employee>> = flow {
        // TODO handle non-happy paths like missing employee entry
        //     val cachedEmployee = dao.getById(id).toEmployee()
        //     emit(Resource.Success(cachedEmployee))
    }
}
