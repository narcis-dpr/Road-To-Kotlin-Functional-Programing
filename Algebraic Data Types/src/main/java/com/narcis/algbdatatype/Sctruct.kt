package com.narcis.algbdatatype

import compose

typealias BoolPair = Pair<Boolean, Boolean>

enum class Triage {
    RED, YELLOW, GREEN
}
typealias BoolTriage = Pair<Boolean, Triage>

typealias UnitTriage = Pair<Unit, Triage> // unit is equivalent to the value 1 when you multiply by it

typealias TriageUnit = Pair<Triage, Unit>

// usage :
fun isEven(a: Int): Boolean = a%2 == 0

fun booleanToInt(even: Boolean): Int = if (even) 1 else 0

val isEvenInt = ::isEven compose ::booleanToInt


