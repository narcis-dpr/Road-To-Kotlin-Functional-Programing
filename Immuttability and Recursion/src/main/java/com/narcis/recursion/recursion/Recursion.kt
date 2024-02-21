package com.narcis.recursion.recursion

fun recAddMulti5(list: List<Int>): Int {
    fun loop(i: Int, sum: Int): Int = when {
        i == list.size -> sum
        list[i] % 5 == 0 -> loop(i+1, sum+ list[i])
        else -> loop(i+1, sum)
    }
    return loop(0, 0)
}
fun main() {
    val list = listOf(1, 5, 10, 12, 34, 55, 80, 23, 35, 12, 80)
    println(recAddMulti5(list))
}