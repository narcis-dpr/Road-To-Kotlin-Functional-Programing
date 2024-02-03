package com.narcis.expressionevaluationlaziness

import kotlin.math.sqrt

val empty = {}
val distance = { x1: Double, y1:Double, x2: Double, y2: Double ->
    val sqr1 = (x2 - x1) * (y2 - y1)
    val sqr2 = (y2 - y1) * (y2 - y1)
    sqrt(sqr1 + sqr2)
}