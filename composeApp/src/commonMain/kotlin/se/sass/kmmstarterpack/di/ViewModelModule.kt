package se.sass.kmmstarterpack.di

import org.koin.dsl.module
import se.sass.kmmstarterpack.presentation.ui.first.FirstScreenViewModel

val viewModelModule = module {
    factory {
        FirstScreenViewModel(get())
    }
}