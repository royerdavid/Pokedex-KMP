package royerdavid.pokedex.app.data.mappers

import royerdavid.pokedex.app.data.local.entity.PokemonSummaryEntity
import royerdavid.pokedex.app.data.remote.dto.NamedApiResourceDto
import royerdavid.pokedex.app.domain.model.PokemonSummary
import kotlin.test.Test
import kotlin.test.assertEquals

class PokemonMappersTest {

    data class PokemonSummaryData(
        val id: Int,
        val name: String
    ) {
        private val imageUrl = getPokemonImageUrl(id)

        val dto = NamedApiResourceDto(name = name, url = "https://pokeapi.co/api/v2/pokemon/$id/")
        val entity = PokemonSummaryEntity(id = id, name = name, imageUrl = imageUrl)
        val model = PokemonSummary(id = id, name = name, imageUrl = imageUrl)
    }

    companion object {
        val pikachu = PokemonSummaryData(40, "pikachu")
    }

    @Test
    fun `should convert pokemon summary DTO to entity`() {
        assertEquals(
            pikachu.entity,
            pikachu.dto.toEntity()
        )
    }

    @Test
    fun `should convert pokemon summary entity to model`() {
        assertEquals(
            pikachu.model,
            pikachu.entity.toModel()
        )
    }
}
