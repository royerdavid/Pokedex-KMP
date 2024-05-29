package royerdavid.employeedirectorykmp.features.employees.domain

import kotlinx.coroutines.flow.Flow
import royerdavid.employeedirectorykmp.core.util.Resource
import royerdavid.employeedirectorykmp.features.employees.domain.model.Employee

interface EmployeesRepository {
    suspend fun getEmployees(): Flow<Resource<List<Employee>>>
    suspend fun getEmployee(id: String): Flow<Resource<Employee>>
}
