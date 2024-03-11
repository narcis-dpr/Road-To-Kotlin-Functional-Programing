package com.narcis.datatype

/** A functional Single List */
sealed interface FList<out T> {

  companion object {
    @JvmStatic
    fun <T> of(vararg items: T): FList<T> {
      val tail = items.sliceArray(1 until items.size)
      return if (items.isEmpty()) empty() else FCons(items[0], of(*tail))
    }

    @JvmStatic
    fun <T> empty(): FList<T> = Nil
  }
}

internal object Nil : FList<Nothing>
internal data class FCons<T>(val head: T, val tail: FList<T> = Nil) : FList<T>

fun <T, S> FList<T>.match(
  whenNil: () -> S,
  whenCons: (head: T, tail: FList<T>) -> S
) =
  when (this) {
    is Nil -> whenNil()
    is FCons<T> -> whenCons(head, tail)
  }


fun <T> FList<T>.forEach(fn: (T) -> Unit): Unit = match(
  whenNil = {},
  whenCons = { head, tail ->
    fn(head)
    tail.forEach(fn)
  }
)
