package com.narcis.composition


fun pureFunction(x: Int) = x * x - 1 // referentially transparent expression

fun main() {
    pureFunction(5) pipe ::println
    pureFunction(5) pipe ::println
    pureFunction(5) pipe ::println


    functionWithEffect(5) pipe ::println
    functionWithEffect(5) pipe ::println
    functionWithEffect(5) pipe ::println

    listOf(1, 2, 3)
        .map(::pureFunction) pipe ::println


    // this two has the same result and are equal :
    listOf(1, 2, 3)
        .map(::pureFunction).map(::pureFunction) pipe ::println

    listOf(1, 2, 3)
        .map(::pureFunction compose ::pureFunction) pipe ::println

    // this two are not equal (because of side effect) this means functions with side effect dont compose! :
    listOf(1, 2, 3).map(::functionWithEffect).map(::functionWithEffect) pipe ::println
}

// adding side effect :
fun functionWithEffect(x: Int): Int { // returns the same result as pure function but with side effect
    val result = x * x - 1
    println("Result: $result")
    return result
}


// this function is a pure function that dosnt print anything but it delates the responsibility
// of handling the side effect to the caller
fun functionWithWriter(x: Int): Pair<Int, String> {
    val result = x * x - 1
    return result to "Result: $result"
}

typealias Writer<A, B> = (A) -> Pair<B, String>
infix fun <A, B, C> Writer<A, B>.compose (
g: Writer<B, C>
): Writer<A, C> = {a: A ->
    val (b, str) = this(a)
    val (c, str2) = g(b)

    c to "$str\n$str2\n"
}
