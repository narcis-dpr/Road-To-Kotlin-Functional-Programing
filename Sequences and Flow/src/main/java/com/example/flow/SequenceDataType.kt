package com.example.flow

fun main() {
    sequenceOf(1,2,3,4,5)
        .filter(filterOdd.logged("filterOddSeq"))
        .map(double.logged("doubleSeq"))
        //.iterator()
        .count() // for consuming we need a terminal operator


    data class User(
        val id: Int,
        val name: String,
        val email: String
    )
    val userBuilder = ::User.curry()
    val userBuilderSeq = sequenceOf(userBuilder)
    val idSeq = sequenceOf(10, 20, 30)
    val nameSeq = sequenceOf("minni", "donald", "micky")
    val emailSeq = sequenceOf("aaaaaa@aa.com", "bbbb@bb.com")

    val userSeq = userBuilderSeq appl idSeq appl nameSeq appl emailSeq
    userSeq.forEach(::println)
}

fun <A, B> Sequence<A>.ap(
    fn: Sequence<(A) -> B>
): Sequence<B> = sequence {
    val iterator = iterator()
    while (iterator.hasNext()) {
        val fnIterator = fn.iterator()
        val item = iterator.next()
        while (fnIterator.hasNext()) {
            yield(fnIterator.next().invoke(item))
        }
    }
}

infix fun <A, B> Sequence<(A) -> B>.appl(a: Sequence<A>) = a.ap(this)