package royerdavid.pokedex.di

import org.koin.dsl.module
import royerdavid.pokedex.APP_NAME
import royerdavid.pokedex.app.di.appModule
import royerdavid.pokedex.core.di.coreModule


val appRootModule = module {
    includes(
        coreModule(APP_NAME),
        appModule
    )
}
