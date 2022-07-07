package com.example.domain

import retrofit2.Response

sealed class Resource<out T> {

    data class Success<T>(val data: T?) : Resource<T>()

    data class Error<T>(val error: String?) : Resource<T>()

}

fun <T> Resource<T>.handle(onSuccess: (T) -> Unit, onError: (String?) -> Unit) {
    if (this is Resource.Success && this.data != null)
        onSuccess(this.data)
    else
        onError((this as Resource.Error).error)
}

suspend fun <T : Any, R : Any?> handleMappedResponse(
    call: suspend () -> Response<T>,
    toDomainModel: T.() -> R
): Resource<R> {
    try {
        val response = call.invoke()
        return if (response.isSuccessful) {
            Resource.Success(response.body()?.toDomainModel())
        } else {
            val error = response.errorBody()?.string()
            return Resource.Error(error)
        }
    } catch (e: Exception) {
        return Resource.Error(e.message)
    }
}
