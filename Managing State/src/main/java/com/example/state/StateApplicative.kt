package com.example.state

fun replaceSuffix(
    input: String,
    lastToRemove: Int,
    postfix: String
) = input.dropLast(lastToRemove) + postfix

val cReplaceSuffix = ::replaceSuffix.curry()

//infix fun <S, A, B> State<S, (A) -> B>.appl(a: State<S, A>) = a.ap(this)
