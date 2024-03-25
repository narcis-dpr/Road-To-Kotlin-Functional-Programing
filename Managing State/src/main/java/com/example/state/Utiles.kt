package com.example.state


typealias Fun<A,B> = (A) -> B
infix fun <A,B> A.pipe(fn: Fun<A,B>): B = fn(this)

/** Abstraction of functions with multiple input parameters */
typealias Fun2<T1, T2, R> = (T1, T2) -> R
typealias Fun3<T1, T2, T3, R> = (T1, T2, T3) -> R
typealias Fun4<T1, T2, T3, T4, R> = (T1, T2, T3, T4) -> R
typealias Fun5<T1, T2, T3, T4, T5, R> = (T1, T2, T3, T4, T5) -> R

/** Abstraction of curried functions with multiple input parameters */
typealias Chain2<T1, T2, R> = (T1) -> (T2) -> R
typealias Chain3<T1, T2, T3, R> = (T1) -> (T2) -> (T3) -> R
typealias Chain4<T1, T2, T3, T4, R> = (T1) -> (T2) -> (T3) -> (T4) -> R
typealias Chain5<T1, T2, T3, T4, T5, R> = (T1) -> (T2) -> (T3) -> (T4) -> (T5) -> R

fun <T1, T2, R> Fun2<T1, T2, R>.curry(): (T1) -> (T2) -> R = { t1: T1 ->
    { t2: T2 ->
        this(t1, t2)
    }
}

fun <T1, T2, T3, R> Fun3<T1, T2, T3, R>.curry(): (T1) -> (T2) -> (T3) -> R = { t1: T1 ->
    { t2: T2, t3: T3 ->
        this(t1, t2, t3)
    }.curry()
}

fun <T1, T2, T3, T4, R> Fun4<T1, T2, T3, T4, R>.curry(): (T1) -> (T2) -> (T3) -> (T4) -> R =
    { t1: T1 ->
        { t2: T2, t3: T3, t4: T4 ->
            this(t1, t2, t3, t4)
        }.curry()
    }

fun <T1, T2, T3, T4, T5, R> Fun5<T1, T2, T3, T4, T5, R>.curry(): (T1) -> (T2) -> (T3) -> (T4) -> (T5) -> R =
    { t1: T1 ->
        { t2: T2, t3: T3, t4: T4, t5: T5 ->
            this(t1, t2, t3, t4, t5)
        }.curry()
    }


sealed interface FList<out T> {

    companion object {
        @JvmStatic
        fun <T> of(vararg items: T): FList<T> {
            val tail = items.sliceArray(1 until items.size)
            return if (items.isEmpty()) empty() else FCons(items[0], of(*tail))
        }

        @JvmStatic
        fun <T> empty(): FList<T> = Nil
    }
}

internal object Nil : FList<Nothing>
internal data class FCons<T>(val head: T, val tail: FList<T> = Nil) : FList<T>

fun <T, S> FList<T>.match(
    whenNil: () -> S,
    whenCons: (head: T, tail: FList<T>) -> S
) =
    when (this) {
        is Nil -> whenNil()
        is FCons<T> -> whenCons(head, tail)
    }


fun <T> FList<T>.forEach(fn: (T) -> Unit): Unit = match(
    whenNil = {},
    whenCons = { head, tail ->
        fn(head)
        tail.forEach(fn)
    }
)
