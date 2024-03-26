package com.example.sideeffect

val readNameM: IO<String> = IO(readNameT)
val printStringM: (String) -> IO<Unit> = printStringT compose ::IO

fun <T> IO<T>.bind(): T = this(World).first