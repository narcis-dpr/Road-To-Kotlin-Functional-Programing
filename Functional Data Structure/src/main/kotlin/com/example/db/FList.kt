package com.example.db

sealed class FList<out T>
object Nil: FList<Nothing>() // representing an empty list
internal data class FCons<T>( // a head with another Flist as a tail, cons means constructor
    val head: T,
    val tail: FList<T> = Nil // nil is the default tail
) : FList<T>()