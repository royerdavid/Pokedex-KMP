package royerdavid.pokedex.app.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import royerdavid.pokedex.app.domain.model.PokemonSummary
import royerdavid.pokedex.app.presentation.PokemonListUiEvent

@Composable
fun PokemonItem(
    pokemon: PokemonSummary,
    onUiEvent: (PokemonListUiEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable {
                onUiEvent(PokemonListUiEvent.OnItemClick(pokemon))
            }
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        AsyncImage(
            modifier = Modifier.requiredSize(160.dp),
            model = pokemon.imageUrl,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = pokemon.name,
            textAlign = TextAlign.Center
        )
    }
}
