package com.narcis.algbdatatype

typealias Fun2<A, B, C> = (A, B) -> C

fun <A, B, C> Fun2<A, B, C>.curry(): (A) -> (B) -> C = { a: A ->
    { b: B ->
        this(a, b)

    }
}