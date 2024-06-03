package royerdavid.pokedex

import androidx.compose.runtime.Composable
import org.koin.compose.KoinContext
import royerdavid.pokedex.core.ui.theme.PokedexTheme
import royerdavid.pokedex.core.ui.util.InitComposeImageLoader
import royerdavid.pokedex.features.pokemons.presentation.PokemonListScreen

const val APP_NAME = "Pokedex"

@Composable
fun App() {
    KoinContext {
        PokedexTheme {
            InitComposeImageLoader()

            // Load first screen
            PokemonListScreen()
        }
    }
}
