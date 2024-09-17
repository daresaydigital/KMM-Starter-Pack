package se.sass.kmmstarterpack.di

import org.koin.dsl.module
import se.sass.kmmstarterpack.data.api.SampleAPIServiceImp
import se.sass.kmmstarterpack.domain.api.SampleAPIService



val apiModule =
    module {
        single<SampleAPIService> { SampleAPIServiceImp(get()) }
    }