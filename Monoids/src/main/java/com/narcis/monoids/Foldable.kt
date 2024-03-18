package com.narcis.monoids

fun List<Int>.sumList() = fold(0) {a,b -> a + b}

fun String.reversString() = foldRight("") {char, str -> str + char}

fun <T> Foldable<T>.fold(monoid: Monoid<T>): T =fold(monoid.unit, monoid.combine)

fun <A, B, C> (A.(B) -> C).swap(): (B.(A) -> C) = {a: A -> a.this@swap(this)}

fun <T> Monoid<T>.commutate(): Monoid<T> = object : Monoid<T> {
    override val unit: T
        get() = this@commutate.unit
    override val combine: T.(T) -> T
        get() = this@commutate.combine.swap()
}
fun CharSequence.fold(monoid: Monoid<String>): CharSequence =
    this.fold(monoid.unit) {a,b ->
        monoid.combine(a, "$b")
    }
fun main() {
    listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).sumList() pipe ::println
    "supercalifragilisticexpialidocious".reversString() pipe ::println
}

typealias Foldable<T> = Iterable<T>
infix fun <A, B> A.pipe(f: Fun<A, B>): B = f(this)

typealias Fun <A,B> = (A) -> B

