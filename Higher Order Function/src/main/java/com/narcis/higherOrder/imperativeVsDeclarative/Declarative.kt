package com.narcis.higherOrder.imperativeVsDeclarative

/**
 * The declarative approach is closer to how human think.
 */

fun declarative(emails: List<String>): List<String> =
    emails
        .filter { EMAIL_REG_EX.matches(it) }
        .filter { it.length > 10 }
        .take(5)

// readability :
fun isEmailValid(email: String) = EMAIL_REG_EX.matches(email) // pure fun

fun isEmailLongEnough(email: String) = email.length > 10

fun moreDeclarative(emails: List<String>): List<String> =
    emails.filter(::isEmailValid) // use isEmailValid reference as parameter
        .filter(::isEmailLongEnough) //use isEmailLongEnough reference as parameter
        .take(5)
fun main() {
    println(declarative(emails))
}