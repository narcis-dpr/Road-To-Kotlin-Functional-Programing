package com.example.ds

sealed class FList<out T> {
    companion object {
        @JvmStatic
        fun <T> of(vararg items: T): FList<T> {
            val tail = items.sliceArray(1 until items.size)
            return if (items.isEmpty()) {
                empty()
            } else {
                FCons(items[0], of(*tail))
            }
        }

        @JvmStatic
        fun <T> empty(): FList<T> = Nil // as a builder for empty list
    }
    /*
    making this classes internal has the advantage of hiding the actual implementations in code in different
    modules
     */
    internal object Nil : FList<Nothing>() // representing an empty list

    internal data class FCons<T>( // a head with another Flist as a tail, cons means constructor
        val head: T,
        val tail: FList<T> = Nil // nil is the default tail
    ) : FList<T>()
}
fun <T, S> FList<T>.match(
    whenNil: () -> S,
    whenCons: (head: T, tail: FList<T>) -> S
) = when(this) {
    is FList.Nil -> whenNil()
    is FList.FCons -> whenCons(head, tail)
}
fun <T, S> FList<T>.isEmpty(
) = when(this) {
    is FList.Nil -> true
    is FList.FCons -> false
}

