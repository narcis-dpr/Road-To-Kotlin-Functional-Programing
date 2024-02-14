package com.narcis.higherOrder.higherOrder

import java.lang.StringBuilder

// composition with SAM :
/**
 * Char reader
 *
 * Apply interface segregation principle by splitting reader into 2 different functional interface
 */
fun interface CharReader {
    fun readChar()
}

fun interface StringReader {
    fun readString(charReader: CharReader): String
}

val stringReader = StringReader { charReader ->
    val result = StringBuilder()
    do {
        val nextChar = charReader.readChar()
        if (nextChar != null) {
            result.append(nextChar)
        }
    } while (nextChar != null)
        result.toString()
}

fun String.toCharReader(): CharReader {
    var pos = 0
    return CharReader {
        if (pos < this.length) this[pos++] else null
    }
}

fun main() {
    println(stringReader.readString("This is String".toCharReader()))
}