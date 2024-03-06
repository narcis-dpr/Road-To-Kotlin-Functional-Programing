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