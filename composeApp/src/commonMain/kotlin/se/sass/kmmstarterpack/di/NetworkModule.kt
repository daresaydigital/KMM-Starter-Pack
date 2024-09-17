package se.sass.kmmstarterpack.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import se.sass.kmmstarterpack.data.api.SampleAPIServiceImp
import se.sass.kmmstarterpack.domain.api.SampleAPIService

val networkModule =
    module {
        single {
            HttpClient {
                install(ContentNegotiation) {
                    json(
                        Json {
                            ignoreUnknownKeys = true
                            useAlternativeNames = false
                        },
                    )
                }
            }
        }
        single<SampleAPIService> { SampleAPIServiceImp(get()) }
    }