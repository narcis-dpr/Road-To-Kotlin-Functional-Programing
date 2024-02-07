package com.narcis.higherOrder.imperativeVsDeclarative

val EMAIL_REG_EX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})".toRegex()
val emails = listOf(
    "email@emmmaail.com",
    "max@fgh.it",
    "hsajdkjshh",
    "mike@mcarli.it",
    "test@test.co.uk",
    "first.second@ggg.com",
    "12345@qqq.com",
    "123.45",
    "12345@a.b.c.d",
    "fp_is_great@funprog.com",
    "aaaaaaaaa.bbbbb@cccc.com",
    "valid@jjjj.lll",
    "aaaaaaacccc.com",
)

/**
filter, character check and take the first 5 elements in an imperative way:
 this way is called imperative approach or algorithmic programming, meaning you
 write the code specifying the steps the computer must take to accomplish the goal

*/
fun imperative(emails: List<String>): List<String> =
    mutableListOf<String>()
        .apply {
            for (email in emails) {
                if (EMAIL_REG_EX.matches(email) && email.length > 10) {
                    add(email)
                    if (size >= 5) {
                        break
                    }
                }
            }
        }

fun main() {
    println(imperative(emails = emails))
}