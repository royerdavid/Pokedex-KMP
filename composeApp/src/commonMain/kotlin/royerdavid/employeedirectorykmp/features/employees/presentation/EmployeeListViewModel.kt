package royerdavid.employeedirectorykmp.features.employees.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.serialization.SerializationException
import royerdavid.employeedirectorykmp.core.util.Resource
import royerdavid.employeedirectorykmp.features.employees.domain.EmployeesRepository


class EmployeeListViewModel(
    private val employeesRepository: EmployeesRepository
) : ViewModel() {

    private val _state = MutableStateFlow(EmployeeListState(isLoading = true))
    val state = _state.asStateFlow()

    init {
        loadEmployees()
    }

    private fun loadEmployees() {
        viewModelScope.launch {
            employeesRepository.getEmployees().onEach { resource ->
                when (resource) {
                    is Resource.Success ->
                        _state.value = state.value.copy(
                            isLoading = false,
                            emptyStateText = if (resource.data.isNullOrEmpty()) {
                                "TODO R.string.empty_state_no_employees"
                                //resourcesProvider.getString(R.string.empty_state_no_employees)
                            } else {
                                ""
                            },
                            employeeList = resource.data ?: emptyList()
                        )

                    is Resource.Error ->
                        // TODO: implement snackbar for when there's an error but we have cached data
                        _state.value = state.value.copy(
                            isLoading = false,
                            emptyStateText = if (resource.exception is SerializationException) {
                                "TODO R.string.invalid_response"
                                //resourcesProvider.getString(R.string.invalid_response)
                            } else {
                                "TODO R.string.unexpected_error"
                                //resourcesProvider.getString(R.string.unexpected_error)
                            },
                            employeeList = resource.data ?: emptyList()
                        )

                    is Resource.Loading ->
                        _state.value = state.value.copy(
                            isLoading = true,
                            employeeList = resource.data ?: state.value.employeeList
                        )
                }
            }.launchIn(this)
        }
    }
}
