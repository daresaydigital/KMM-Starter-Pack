package se.sass.kmmstarterpack.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import se.sass.kmmstarterpack.presentation.ui.first.FirstScreenViewModel

object InjectionHelper : KoinComponent {
    val firstScreenViewModel: FirstScreenViewModel by inject()
}


fun initKoin(config: () -> Unit = {}) {
    startKoin {
        config.invoke()
        modules(
            apiModule,
            networkModule,
            repositoryModule,
            viewModelModule,
        )
    }
}