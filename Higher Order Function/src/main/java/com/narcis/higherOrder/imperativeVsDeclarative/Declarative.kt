package com.narcis.higherOrder.imperativeVsDeclarative

/**
 * The declarative approach is closer to how human think.
 */

fun declarative(emails: List<String>): List<String> =
    emails
        .filter { EMAIL_REG_EX.matches(it) }
        .filter { it.length > 10 }
        .take(5)


fun main() {
    println(declarative(emails))
}