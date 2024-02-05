package com.narcis.expressionevaluationlaziness

fun <A, B> Fun<A, B>.memo(): Fun<A, B> {
    val cache by lazy { mutableMapOf<A, B>() } // lazy allows you to create just one instance of the cache in a lazy way
    return {a:A ->  // a lambda of type Fun<A,B> that accepts a parameter of type A
        val cached = cache[a]
        if (cached == null) {
            cache[a] = this(a)
        }
        cache[a]!!
    }
}

fun main() {
    val testFunction = {a: Int -> println("Evaluating... $a"); a*2 }
    println("Running testFunction 4 times")
    testFunction(2)
    testFunction(2)
    testFunction(2)
    testFunction(3)
    val memoTestingFunction = testFunction.memo()
    println("Running memo testing function 4 times")
    memoTestingFunction(2)
    memoTestingFunction(2)
    memoTestingFunction(2)
    memoTestingFunction(3)


}
