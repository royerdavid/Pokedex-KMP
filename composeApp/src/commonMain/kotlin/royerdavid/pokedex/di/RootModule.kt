package royerdavid.pokedex.di

import org.koin.dsl.module
import royerdavid.pokedex.app.di.appModule
import royerdavid.pokedex.core.di.coreModule
import royerdavid.pokedex.core.di.corePlatformModule


val rootModule = module {
    includes(
        coreModule,
        corePlatformModule,

        // Feature specific modules
        appModule
    )
}
