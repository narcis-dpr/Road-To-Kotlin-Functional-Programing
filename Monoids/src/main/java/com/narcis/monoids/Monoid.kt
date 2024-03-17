package com.narcis.monoids

interface Monoid<T> {
    val unit: T
    val combine: (T, T) -> T
}