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

val safeReadNameT: WorldT<Result<String>> = safeReadName

