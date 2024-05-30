package royerdavid.pokedex

import androidx.compose.runtime.Composable
import royerdavid.pokedex.core.ui.theme.PokedexTheme
import royerdavid.pokedex.core.ui.util.InitComposeImageLoader
import royerdavid.pokedex.features.pokemons.presentation.PokemonListScreen

@Composable
fun RootScreen() {
    PokedexTheme {
        InitComposeImageLoader()
        PokemonListScreen()
    }
}
