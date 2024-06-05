package royerdavid.pokedex.features.pokemons.domain.use_case

import royerdavid.pokedex.features.pokemons.domain.PokemonsRepository

class GetPokemons(
    private val repository: PokemonsRepository
) {
//
//    operator fun invoke(): Result<List<Pokemon>> {
//        return repository.getPokemons()
//    }
}
