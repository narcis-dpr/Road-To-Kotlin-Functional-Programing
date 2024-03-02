package com.narcis.composition


fun main() {
    val double = { a: Int -> a * 2 }
    val square = { a: Int -> a * a }
    val sum = { a: Int, b: Int -> a + b }
    val stringify = Int::toString // returns the string representation of the int input value

    // a practice of currying :
    val addThree = sum(3)
    val result = addThree(4)

    val curriedSum = sum.curry()
    val addThree2 = curriedSum(3)
    println(result)
    val result2 = addThree2(4)
    println(result2)

    /// more complete composition :
//    fun comp(a: Int, b: Int): String {
//        val currySum: (Int) -> (Int) -> Int = sum.curry()
//        val doubleComposeSum = double compose currySum
//        val right: (Int) -> Int = doubleComposeSum(a)
//        return (square compose right compose stringify)(b)
//    }
   // refactor above comp with pipe :
    fun comp(a: Int, b: Int): String = b pipe (square compose (a pipe (double compose sum.curry() )) compose stringify)

    fun comp1(a: Int, b: Int): String {
        val right = (double compose sum.curry())(a)
        return (square compose right compose stringify)(b)
    }

    println(comp1(10, 2))
}

fun sum(a: Int): (Int) -> Int = { b: Int -> a + b }

// make curry generic :
typealias Fun2<A, B, C> = (A, B) -> C // type of a function that gets 2 var and returns one

fun <A, B, C> Fun2<A, B, C>.curry(): (A) -> (B) -> C = { a: A -> // the type of curry is (Int) -> (Int) -> Int

    { b: B ->
        this(a, b)
    }
}

// inorder to remove parentheses :
infix fun <A, B> A.pipe(f: Fun<A, B>): B = f(this)