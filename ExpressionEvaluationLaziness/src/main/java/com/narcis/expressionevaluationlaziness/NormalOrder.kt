package com.narcis.expressionevaluationlaziness
/**
 * lazy evaluation is a balanced compromise between applicative-order and normal-order
 *
 * */
fun addL(x: () -> Int, y: () -> Int): () -> Int {
    return { // the fun returns a lambda expression
        println("addL")
        x() + y()
    }
}
fun tripleL(x: () -> Int): () -> Int {
    return { println("tripleL")
    addL(addL(x,x), x)()
    }
}

fun divideL(x: () -> Int, y: () -> Int): () -> Int {
    return { println("divideL")
    x()/y()}
}

fun averageL(x: () -> Int, y: () -> Int): () -> Int {
    return {
        println("averageL")
        divideL(addL(x, y),{2})()
    }
}

fun main() {
    tripleL(averageL({2}, {4}))()
}