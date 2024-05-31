package royerdavid.pokedex

import android.app.Application
import royerdavid.pokedex.di.KoinInitializer

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}
