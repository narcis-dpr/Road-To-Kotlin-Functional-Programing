package com.example.state

fun replaceSuffix(
    input: String,
    lastToRemove: Int,
    postfix: String
) = input.dropLast(lastToRemove) + postfix

val cReplaceSuffix = ::replaceSuffix.curry()

fun <S, T, R> State<S, T>.ap(fn: State<S, (T) -> R>): State<S, R> = State { s0: S ->
    val (t, s1) = this(s0)
    val (fnValue, s2) = fn(t)
    fnValue to s2(s1)
}
infix fun <S, A, B> State<S, (A) -> B>.appl(a: State<S, A>) = a.ap(this)
fun main() {

}