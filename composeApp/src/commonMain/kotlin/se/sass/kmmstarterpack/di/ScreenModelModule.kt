package se.sass.kmmstarterpack.di

import org.koin.dsl.module
import se.sass.kmmstarterpack.presentation.ui.first.FirstScreenModel

val screenModelModule = module {
    factory {
        FirstScreenModel(get())
    }
}