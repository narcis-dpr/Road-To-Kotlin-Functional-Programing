package com.example.flow

typealias SuspendStateResultTransform<S, T> = suspend (S) -> Pair<S, Result<T>>

data class SuspendableStateResult<S, T>(
    val sst: SuspendStateResultTransform<S, T>
) {
    companion object {
        @JvmStatic
        fun <S, T> lift(value: T): SuspendableStateResult<S, T> = SuspendableStateResult { state ->
            state to Result.success(value)
        }
    }
}

fun <S, A, B> SuspendableStateResult<S, A>.flatMap(
    fn: suspend (A) -> SuspendableStateResult<S, B>
): SuspendableStateResult<S, B> = SuspendableStateResult { s0 ->
    val (s1, res) = sst(s0)
    res.fold(onSuccess = { a: A ->
        fn(a).sst(s1)
    }, onFailure = { thowable ->
        s1 to Result.failure(thowable)
    })
}