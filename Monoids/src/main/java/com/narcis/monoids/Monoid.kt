package com.narcis.monoids

interface Monoid<T> {
    val unit: T
    val combine:  T.(T) -> T   // also : (T) -> (T) -> T
}

object MonoidIntAdd: Monoid<Int> {
    override val unit: Int
        get() = 0
    override val combine: Int.(Int) -> Int
        get() = Int::plus
}