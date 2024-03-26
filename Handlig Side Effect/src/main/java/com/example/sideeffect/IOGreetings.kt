package com.example.sideeffect

val readNameM: IO<String> = IO(readNameT)
val printStringM: (String) -> IO<Unit> = printStringT compose ::IO

fun <T> IO<T>.bind(): T = this(World).first

fun askNameAndPrintGreetingIO() : () -> Unit = {
    printStringM("whats your name?").bind()
    val name = readNameM.bind()
    printStringM("Hello $name! \n").bind()
}

fun main() {
    askNameAndPrintGreetingIO().invoke()
}