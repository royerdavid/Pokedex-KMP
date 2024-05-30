package royerdavid.pokedex.features.employees.domain

import kotlinx.coroutines.flow.Flow
import royerdavid.pokedex.core.util.Resource
import royerdavid.pokedex.features.employees.domain.model.Pokemon

interface PokemonsRepository {
    suspend fun getEmployees(): Flow<Resource<List<Pokemon>>>
    suspend fun getEmployee(id: String): Flow<Resource<Pokemon>>
}
