package com.narcis.algbdatatype

sealed class NaturalNumber

object Zero : NaturalNumber()

data class Successor(val prev: NaturalNumber) : NaturalNumber()

val ZERO = Zero

val ONE = Successor(Zero)

val TWO = Successor(Successor(Zero))

val THREE = Successor(Successor(Successor(Zero)))

sealed interface FList<out A>
object Nil : FList<Nothing>
data class FCons<A>(
    val head: A,
    val tail: FList<A> = Nil
) : FList<A>

fun FList<Int>.sum(): Int = when(this) {
    is FCons -> head + tail.sum()
    Nil -> 0
}

fun main() {
    // test list :
    FCons(1, FCons(2, FCons(3, FCons(4, FCons(5, Nil)))))


}