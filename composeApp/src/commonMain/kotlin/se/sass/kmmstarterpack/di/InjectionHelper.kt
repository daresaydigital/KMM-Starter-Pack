package se.sass.kmmstarterpack.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin


fun initKoin(config: () -> Unit = {}) {
    startKoin {
        config.invoke()
        modules(
            apiModule,
            networkModule,
            repositoryModule,
            screenModelModule,
        )
    }
}