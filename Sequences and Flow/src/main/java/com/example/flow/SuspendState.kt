package com.example.flow

typealias SuspendStateTransformer<S, T> = suspend (S) -> Pair<S, T>

data class SuspendableState<S, T>(
    val sst: SuspendStateTransformer<S, T>
) {
    companion object {
        @JvmStatic
        fun <S, T> lift(
            value: T
        ): SuspendableState<S, T> =
            SuspendableState { state -> state to value }
    }
}

fun <S, A, B> SuspendableState<S, A>.map(
    fn: SuspendFun<A, B>
): SuspendableState<S, B> =
    SuspendableState { s0: S ->
        val (s1, a) = this.sst(s0)
        s1 to fn(a)
    }

fun <S, A, B> SuspendableState<S, A>.flatMap(
    fn: suspend (A) -> SuspendableState<S, B>
): SuspendableState<S, B> =
    SuspendableState { s0: S ->
        val (s1, a) = this.sst(s0)
        fn(a).sst(s1)
    }