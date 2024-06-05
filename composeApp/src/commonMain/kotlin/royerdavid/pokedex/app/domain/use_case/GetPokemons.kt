package royerdavid.pokedex.app.domain.use_case

import royerdavid.pokedex.app.domain.PokemonsRepository

class GetPokemons(
    private val repository: PokemonsRepository
) {
//
//    operator fun invoke(): Result<List<Pokemon>> {
//        return repository.getPokemons()
//    }
}
