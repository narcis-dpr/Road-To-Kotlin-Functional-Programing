package com.narcis.composition

import java.lang.NumberFormatException

typealias Opt<A, B> = (A) -> B?

infix fun <A, B, C> Opt<A, B>.compose(
    g: Opt<B, C>
): Opt<A, C> = { a: A ->
    val b = this(a)
    if (b != null) {
        g(b)
    } else {
        null
    }
}

fun main() {
    val strToInt = { str: String ->
        try {
            str.toInt()
        } catch (nfe: NumberFormatException) {
            null
        }
    }

    val findUser = { id: Int ->
        if (id == 3) User(3, "Max") else null
    }
    val strToUser = strToInt compose findUser
    strToUser("a") pipe ::println
    strToUser("2") pipe ::println
    strToUser("3") pipe ::println
}

data class User(
    val id: Int,
    val name: String
)