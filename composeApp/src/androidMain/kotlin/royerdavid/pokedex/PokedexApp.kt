package royerdavid.pokedex

import android.app.Application

class PokedexApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}
