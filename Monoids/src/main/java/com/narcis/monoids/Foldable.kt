package com.narcis.monoids

fun List<Int>.sumList() = fold(0) {a,b -> a + b}

fun String.reversString() = foldRight("") {char, str -> str + char}

fun <T> Foldable<T>.fold(monoid: Monoid<T>): T =fold(monoid.unit, monoid.combine)

fun main() {
    listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).sumList() pipe ::println
    "supercalifragilisticexpialidocious".reversString() pipe ::println
}

typealias Foldable<T> = Iterable<T>
infix fun <A, B> A.pipe(f: Fun<A, B>): B = f(this)

typealias Fun <A,B> = (A) -> B

