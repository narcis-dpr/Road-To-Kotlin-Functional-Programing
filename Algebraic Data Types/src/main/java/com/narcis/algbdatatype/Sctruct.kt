package com.narcis.algbdatatype

typealias BoolPair = Pair<Boolean, Boolean>

enum class Triage {
    RED, YELLOW, GREEN
}
typealias BoolTriage = Pair<Boolean, Triage>

typealias UnitTriage = Pair<Unit, Triage> // unit is equivalent to the value 1 when you multiply by it

typealias TriageUnit = Pair<Triage, Unit>

