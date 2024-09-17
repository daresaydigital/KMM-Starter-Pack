package se.sass.kmmstarterpack.data

import io.ktor.client.plugins.HttpRequestTimeoutException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import se.sass.kmmstarterpack.data.ktor.ResponseModel

fun <T> apiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    loadingMessage: String = "loading",
    req: suspend () -> T,
): Flow<ResponseModel<T>> =
    flow {
        emit(ResponseModel.Loading(loadingMessage))
        try {
            emit(
                ResponseModel.Data(
                    withContext(dispatcher) {
                        req.invoke()
                    },
                ),
            )
        } catch (e: Throwable) {
            emit(handleError(e))
        }
    }

fun <T> handleError(exception: Throwable): ResponseModel.Error<T> {
    return when (exception) {
        is HttpRequestTimeoutException -> ResponseModel.Error<T>(Throwable("Time Out"))
        else -> ResponseModel.Error<T>(exception)
        // TODO add different error types
    }
}
