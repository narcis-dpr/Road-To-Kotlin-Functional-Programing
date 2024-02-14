package com.narcis.higherOrder.higherOrder

import java.lang.StringBuilder

// composition with SAM
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