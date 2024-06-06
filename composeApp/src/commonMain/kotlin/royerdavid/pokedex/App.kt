package royerdavid.pokedex

import androidx.compose.runtime.Composable
import org.koin.compose.KoinContext
import royerdavid.pokedex.app.presentation.PokemonListScreen
import royerdavid.pokedex.core.ui.theme.PokedexTheme
import royerdavid.pokedex.core.ui.util.InitComposeImageLoader

const val APP_NAME = "Pokédex-KMP"

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
