package se.sass.kmmstarterpack.di

import org.koin.dsl.module
import se.sass.kmmstarterpack.data.api.SampleAPIServiceImp
import se.sass.kmmstarterpack.data.repositoryImp.SampleRepositoryImp
import se.sass.kmmstarterpack.domain.api.SampleAPIService
import se.sass.kmmstarterpack.domain.repository.SampleRepository


val repositoryModule =
    module {
        single<SampleRepository> { SampleRepositoryImp(get()) }
    }