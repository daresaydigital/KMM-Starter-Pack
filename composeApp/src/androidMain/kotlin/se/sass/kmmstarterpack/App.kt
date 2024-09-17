package se.sass.kmmstarterpack

import android.app.Application
import se.sass.kmmstarterpack.di.initKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}