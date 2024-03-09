package com.narcis.datatype

sealed class Optional <out T> { // this class has a type parameter and its covariant
    companion object {
        @JvmStatic
        fun <T> lift(value: T): Optional<T> = Some(value) // allows you to get Optional<T> from given value of type T

        @JvmStatic
        fun <T> empty(): Optional<T> = None
    }
}

object None: Optional<Nothing>() // the case of container is empty
data class Some<T>(val value: T): Optional<T>()

typealias Fun<A,B> = (A) -> B
// extensions :

fun <A, B> Optional<A>.map(fn: Fun<A, B>): Optional<B> =
    when(this) {
        is None -> Optional.empty()
        is Some<A> -> Optional.lift(fn(value))
    }

fun <A, B> Optional<A>.flatMap(
    fn: Fun<A, Optional<B>>
): Optional<B> = when(this) {
    is None -> Optional.empty()
    is Some<A> -> {
        val res = fn(value)
        when(res) {
            is None -> Optional.empty()
            is Some<B> -> Optional.lift(res.value)
        }
    }
}

fun <A> Optional<A>.getOrDefault(defaultValue: A): A =
    when(this) {
        is None -> defaultValue
        is Some<A> -> value
    }