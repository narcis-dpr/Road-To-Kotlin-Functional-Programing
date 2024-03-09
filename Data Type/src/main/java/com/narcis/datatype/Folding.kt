package com.narcis.datatype

fun List<Int>.imperativeSum(): Int {
    var sum = 0
    for (element in this) {
        sum += element
    }
    return sum
}
fun List<Int>.declarativeSum(): Int {
    tailrec fun helper(pos: Int, acc: Int): Int {
        if (pos == size) {
            return acc
        }
        return helper(pos + 1, this[pos] + acc)
    }
    return helper(0, 0)
}

fun List<Int>.declarativeProduct(): Int {
    tailrec fun helper(pos: Int, acc: Int): Int {
        if (pos == size) {
            return acc
        }
        return helper(pos + 1, this[pos] * acc)
    }
    return helper(0, 1)
}

fun <T, S> List<T>.declarativeFold(
    start: S,
    combineFunc: (S, T) -> S
): S {
    tailrec fun helper(pos: Int, acc: S): S {
        if (pos == size) {
            return acc
        }
        return helper(pos+1, combineFunc(acc, this[pos]))
    }
    return helper(0, start)
}
fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    list.imperativeSum() pipe ::println
    list.declarativeSum() pipe ::println
    list.declarativeProduct() pipe ::println

    list.declarativeFold(0) {acc, item ->
        acc + item
    } pipe ::println

    list.declarativeFold(1) {acc, item ->
        acc * item
    } pipe ::println
}