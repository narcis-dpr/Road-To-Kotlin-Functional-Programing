package com.example.flow

fun <T, R> Generator<T>.map(fn: (T) -> R): Generator<R> = object : Generator<R> {
    override fun generate(n: Int): List<R> = this@map.generate(n).map(fn)

}