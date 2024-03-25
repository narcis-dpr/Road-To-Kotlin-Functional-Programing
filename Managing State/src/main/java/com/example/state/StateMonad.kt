package com.example.state

fun <S, A, B> State<S, A>.flatMap(fn: (A) -> State<S, B>): State<S, B> = State { s0: S ->
    val (a, s1) = this(s0)
    fn(s1)(a)
}