package royerdavid.employeedirectorykmp.features.employees.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import royerdavid.employeedirectorykmp.features.employees.data.remote.dto.EmployeesRootDto


/**
 * API calls for `employees` endpoint
 */
class EmployeesApi(private val ktorClient: HttpClient) {

    suspend fun getEmployees(): Result<EmployeesRootDto> = runCatching {
        ktorClient.get("employees.json").body()
//        ktorClient.get("employees_malformed.json").body()
//        ktorClient.get("employees_empty.json").body()
    }
}
