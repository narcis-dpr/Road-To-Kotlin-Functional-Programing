package com.narcis.algbdatatype


fun func0(triage: Triage): Boolean = when(triage) {
    Triage.RED -> false
    Triage.YELLOW -> false
    Triage.GREEN -> false
}

fun func1(triage: Triage): Boolean = when(triage) {
    Triage.RED -> false
    Triage.YELLOW -> false
    Triage.GREEN -> true
}

fun func2(triage: Triage): Boolean = when(triage) {
    Triage.RED -> false
    Triage.YELLOW -> true
    Triage.GREEN -> false
}

fun func3(triage: Triage): Boolean = when(triage) {
    Triage.RED -> false
    Triage.YELLOW -> true
    Triage.GREEN -> true
}

fun func4(triage: Triage): Boolean = when(triage) {
    Triage.RED -> true
    Triage.YELLOW -> false
    Triage.GREEN -> false
}

fun func5(triage: Triage): Boolean = when(triage) {
    Triage.RED -> true
    Triage.YELLOW -> false
    Triage.GREEN -> true
}

fun func6(triage: Triage): Boolean = when(triage) {
    Triage.RED -> true
    Triage.YELLOW -> true
    Triage.GREEN -> false
}

fun func7(triage: Triage): Boolean = when(triage) {
    Triage.RED -> true
    Triage.YELLOW -> true
    Triage.GREEN -> true
}
