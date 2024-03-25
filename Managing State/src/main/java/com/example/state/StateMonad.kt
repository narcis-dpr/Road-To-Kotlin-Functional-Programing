package com.example.state

fun <S, A, B> State<S, A>.flatMap(fn: (A) -> State<S, B>): State<S, B> = TODO()