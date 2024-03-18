package com.narcis.monoids

fun <T> mergeAndCombine(
    listA: List<T>,
    listB: List<T>,
    combine: (T, T) -> T
): List<T> {
    var i = 0
    var j = 0
    val result = mutableListOf<T>()
    while (i < listA.size || j < listB.size) {
        val first = if (i < listA.size) listA[i] else null
        val second = if (j < listB.size) listB[i] else null

        if (first != null && second != null) {
            result.add(combine(first, second))
        } else if (first != null) {
            result.add(first)
        } else if (second !=null) {
            result.add(second)
        }
        i++
        j++
    }
    return result
}