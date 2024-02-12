package com.narcis.higherOrder.higherOrder

// classical bubble sort
fun bubbleSort(values: IntArray) {
    for (i in values.size -1 downTo 0) {
        for (j in 0 until i) {
            if (values[j] > values[j + 1]) {
                swap(values, j, j + 1)
            }
        }
    }
}
fun main() {
    val array = intArrayOf(10, 5, 2, 7, 8, 3)
    bubbleSort(array)
    array.printAll()
}




fun swap(values: IntArray, i: Int, j: Int) {
    if (values[i] != values[j]) {
        val tmp = values[i]
        values[i] = values[j]
        values[j] = tmp
    }
}
fun IntArray.printAll() {
    this.forEach {
        print(" $it")
    }
}