package com.narcis.recursion.recursion

fun main() {
    // imperative approach
    var total = 0
    val list = listOf(1, 5, 10, 12, 34, 55, 80, 23, 35, 12, 80)
    for (i in list.indices) {
        if (list[i]%5 == 0) {
            total += list[i]
        }
    }
    println("Total: $total")

    // declarative approach : in this case you dont see anything mutable, you dont see any index to update for iterating over the list
    // mutation is hidden in a well-tested and safe place
    val multipleOf5 = {value: Int -> value%5 == 0}
    val totalD = listOf(1, 5, 10, 12, 34, 55, 80, 23, 35, 12, 80)
        .filter(multipleOf5)
        .sum()

    println("Total: $total")
    println("TotalD: $total")

}