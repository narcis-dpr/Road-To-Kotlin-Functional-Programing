package com.example.sideeffect

import java.util.Scanner

val safeReadName: (World) -> Pair<Result<String>, World> = {w: World ->
    try {
        Result.success(Scanner(System.`in`).nextLine()) to World
    } catch (rte: RuntimeException) {
        Result.failure<String>(rte) to World
    }
}
val safeReadNameError: (World) -> Pair<Result<String>, World> = {w: World ->
    Result.failure<String>(
        RuntimeException("Something went wrong!")
    ) to World
}

val safeReadNameT: WorldT<Result<String>> =  safeReadNameError //safeReadName

val safePrintStringT: (String) -> WorldT<Result<Unit>> = {str: String ->
    {w: World ->
        Result.success(Unit) to printString(str)(w)
    }
}

/*
    the monadic versions :
 */

val safeReadNameM: IO<Result<String>> = IO(safeReadNameT)

val safePrintStringM: (String) -> IO<Result<Unit>> =
    safePrintStringT compose ::IO


fun safeAskNameAndPrintGreetingsIO(): () -> Result<Unit> = {
    safePrintStringM("whats your name?").bind()
    // .flatMap { _ -> safeReadNameM.bind() : ERROR ! flatMap not found
    // flatMap { name -> safePrintStringM(Hello $name! \n).bind()
}

fun main() {
    safeAskNameAndPrintGreetingsIO().invoke().fold(
        onSuccess = { _ -> },
        onFailure = {ex -> println(" Error: $ex ") }
    )
}