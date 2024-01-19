package com.narcis.fundamentals.utiles

fun assertOrThrow(message: String, fn: () -> Boolean) {
    if (!fn()) {
        throw AssertionError(message)
    }
}