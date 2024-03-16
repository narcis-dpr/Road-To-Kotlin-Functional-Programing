package com.narcis.algbdatatype

sealed class NaturalNumber

object Zero: NaturalNumber()

data class Successor(val prev: NaturalNumber): NaturalNumber()

val ZERO = Zero

val ONE = Successor(Zero)

val TWO = Successor(Successor(Zero))

val THREE = Successor(Successor(Successor(Zero)))
