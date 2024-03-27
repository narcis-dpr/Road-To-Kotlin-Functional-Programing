package com.example.flow

fun main() {
    sequenceOf(1,2,3,4,5)
        .filter(filterOdd.logged("filterOddSeq"))
        .map(double.logged("doubleSeq"))
        //.iterator()
        .count() // for consuming we need a terminal operator
}