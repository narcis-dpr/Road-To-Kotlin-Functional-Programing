package com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative

sealed class ResultAp <out E: Throwable, out T> {
    companion object {
        @JvmStatic
        fun <E: Throwable> error(error: E): ResultAp<E, Nothing> = Error(error)

        @JvmStatic
        fun <T> success(value: T): ResultAp<Nothing, T> = Success(value)
    }
}

data class Error<E: Throwable> (val error: E) : ResultAp<E, Nothing>()
data class Success<T>(val value: T): ResultAp<Nothing, T>()
fun <E1: Throwable, E2: Throwable, T> ResultAp<E1, T>.errorMap(fl: (E1) -> E2): ResultAp<E2, T> = when(this) {
    is Error -> ResultAp.error(fl(error))
    is Success -> this
}

fun <E: Throwable, T, R> ResultAp<E, T>.successMap(fr: (T) -> R ): ResultAp<E, R> = when(this) {
    is Error<E> -> this
    is Success<T> -> ResultAp.success(fr(value))
}