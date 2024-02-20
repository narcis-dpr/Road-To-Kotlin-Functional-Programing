package com.narcis.recursion.immutability.cost

/*
kotlin maps Int? to Integer
maps Int to int
 */
fun main() {
    val a: Int ?= 200
    val b: Int ?= 200
    println("Equals ${a == b}")
    println("Same ${a === b}") // for 200 this is false and for 1 its true
}