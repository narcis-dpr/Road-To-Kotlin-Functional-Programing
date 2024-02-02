package com.narcis.fundamentals.concepts

import com.narcis.fundamentals.utiles.assertOrThrow

/*
the functions are still impure but they are easier to test with the help of logger
 */
interface Logger {
    fun log(msg: String)
}

val StdLogger = object : Logger {
    override fun log(msg: String) {
        println(msg)
    }
}

fun shiftLeftWithLogger(logger: Logger, x: Int): Int {
    logger.log("shift left of $x")
    return x shl 1
}

fun notWithLogger(logger: Logger, x: Int): Int {
    logger.log("Negate $x")
    return x.inv()
}

// for testing :
class MockLogger : Logger {
    private val internalLog = StringBuilder()
    val log: String
        get() = internalLog.toString()

    override fun log(msg: String) {
        internalLog.append(msg)
    }
}

fun main() {
    val mockLogger1 = MockLogger()
    shiftLeftWithLogger(mockLogger1, 10)
    assertOrThrow("Problem testing shiftLeft()") {
        mockLogger1.log == "shift left of 10"
    }
    val mockLogger2 = MockLogger()
    notWithLogger(mockLogger2, 10)
    assertOrThrow("problem testing not()") {
        mockLogger2.log == "Negate 10"
    }
}
