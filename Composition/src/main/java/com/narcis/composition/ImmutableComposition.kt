package com.narcis.composition

data class Counter(
    val count: Int = 1
)

fun squareWithImmutableEffect(x: Int): Pair<Int, Updater<Counter>> {
    val result = x * x
    return result to {counter -> Counter(counter.count * 10) }
}

fun doubleWithImmutableEffect(x: Int): Pair<Int, Updater<Counter>> {
    val result = x * 2
    return result to { counter -> Counter(counter.count / 2) }
}

fun main() {
    val composed = ::squareWithImmutableEffect compose ::doubleWithImmutableEffect compose
            ::squareWithImmutableEffect

    val counter = Counter()
    val (result, compUpdate) = composed(3)
    result pipe ::println
    counter pipe compUpdate pipe ::println
}