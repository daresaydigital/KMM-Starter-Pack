package se.sass.kmmstarterpack.data.ktor

sealed class ResponseModel<T> {
    data class Data<T>(val data: T) : ResponseModel<T>()

    data class Loading<T>(val message: String = "") : ResponseModel<T>()

    data class Error<T>(val error: Throwable) : ResponseModel<T>()

    class Idle<T>: ResponseModel<T>()
}