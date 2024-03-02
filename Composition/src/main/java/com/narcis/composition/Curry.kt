package com.narcis.composition


fun main() {
    val double = { a: Int -> a * 2 }
    val square = { a: Int -> a * a }
    val sum = { a: Int, b: Int -> a + b }
    val stringify = Int::toString // returns the string representation of the int input value

    // a practice of currying :
    val addThree = sum(3)
    val result = addThree(4)
    println(result)

    val curriedSum = sum.curry()
    val addThree2 = curriedSum(3)
    val result2 = addThree2(4)
    println(result2)

}

fun sum(a: Int): (Int) -> Int = { b: Int -> a + b }

// make curry generic :
typealias Fun2<A, B, C> = (A, B) -> C // type of a function that gets 2 var and returns one

fun <A, B, C> Fun2<A, B, C>.curry(): (A) -> (B) -> C = { a: A -> // the type of curry is (Int) -> (Int) -> Int

    { b: B ->
        this(a, b)
    }
}