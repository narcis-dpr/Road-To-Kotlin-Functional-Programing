package com.narcis.higherOrder.higherOrder

/**
 * Is larger
 *
 * functional interface
 * SAM : Single Abstract Interface
 */
fun interface IsLarger<T> {
    fun isLarger(a:T, b:T): Boolean
}

fun <T> bubbleSortFI(
    values: Array<T>,
    largerStrategy: IsLarger<T>
) {
    for (i in values.size - 1 downTo 0) {
        for (j in 0 until i) {
            if (largerStrategy.isLarger(values[j], values[j+1])) {
                swap(values, j, j+1)
            }
        }
    }
}

fun main() {
 val array = arrayOf(10, 5, 2, 7, 8, 3)
    bubbleSortFI(array) { first, second ->
        first > second
    }
    array.printAll()
}

fun <T> Array<out T>.printAll() {
    this.forEach {
        print(" $it")
    }
}