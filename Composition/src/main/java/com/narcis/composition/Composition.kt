package com.narcis.composition

typealias Fun<A, B> = (A) -> B
inline infix fun <A, B, C> Fun<B, C>.after(crossinline f: Fun<A, B>): Fun<A, C> =
    { a: A ->
        this(f(a))
    }

inline infix fun <A, B, C> Fun<A, B>.compose(crossinline g: Fun<B, C>): Fun<A, C> =
    { a: A ->
        g(this(a))
    }
fun main() {
    val double = {a: Int -> a*2 } // a pure function
    val square = {a: Int -> a * a } // a pure function
    val stringify = Int::toString
    val stringifyDoubleSquareAfter = stringify after square after double // use after as a composition of double, square and toString
    val stringifyDoubleSquareCompose = double compose square compose stringify

    println(stringifyDoubleSquareAfter(2))
    println(stringifyDoubleSquareCompose(2))
}