package royerdavid.pokedex.features.employees.domain.use_case

import royerdavid.pokedex.features.employees.domain.PokemonsRepository

class GetPokemons(
    private val repository: PokemonsRepository
) {
//
//    operator fun invoke(): Result<List<Employee>> {
//        return repository.getEmployees()
//    }
}