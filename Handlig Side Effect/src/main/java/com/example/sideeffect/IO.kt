package com.example.sideeffect


/*
    The IO data type :
 */
data class IO<T>(val wt: WorldT<T>) {
    companion object {
        @JvmStatic
        fun <S, T> lift(value: T): IO<T> = IO {w -> value to w }
    }
}

operator fun <T> IO<T>.invoke(w: World) = wt(w)

fun <A, B> IO<A>.map (fn: Fun<A, B>): IO<B> = IO {w0 ->
    val (a, w1) = this(w0)
    fn(a) to w1
}

fun <T, R> IO<T>.ap(
    fn: IO<(T) -> R>
): IO<R> = IO {w0: World ->
    val (t, w1) = this(w0)
    val (fnValue, w2) = fn(w1)
    fnValue(t) to w2
}

infix fun <A, B> IO<(A) -> B>.appl(a: IO<A>) = a.ap(this)

fun <A, B> IO<A>.flatMap(fn: (A) -> IO<B>): IO<B> = IO {w0: World ->
    val (a, w1) = this(w0)
    fn(a)(w1)
}