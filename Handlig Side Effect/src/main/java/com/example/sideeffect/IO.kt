package com.example.sideeffect


/*
    The IO data type :
 */
data class IO<T>(val wt: WorldT<T>) {
    companion object {
        @JvmStatic
        fun <S, T> lift(value: T): IO<T> = IO {w -> value to w }
    }
}

operator fun <T> IO<T>.invoke(w: World) = wt(w)
