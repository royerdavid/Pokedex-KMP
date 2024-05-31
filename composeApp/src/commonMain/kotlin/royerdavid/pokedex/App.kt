package royerdavid.pokedex

import androidx.compose.runtime.Composable
import royerdavid.pokedex.core.ui.theme.PokedexTheme
import royerdavid.pokedex.core.ui.util.InitComposeImageLoader
import royerdavid.pokedex.features.pokemons.presentation.PokemonListScreen

@Composable
fun App() {
    PokedexTheme {
        // Init the compose app
        InitComposeImageLoader()

        // Navigation starts here
        PokemonListScreen()
    }
}
