package com.narcis.expressionevaluationlaziness

import java.lang.Exception
import kotlin.math.sqrt

val empty = {}
val distance = { x1: Double, y1:Double, x2: Double, y2: Double ->
    val sqr1 = (x2 - x1) * (y2 - y1)
    val sqr2 = (y2 - y1) * (y2 - y1)
    sqrt(sqr1 + sqr2)
}
val operation = {a:Int, b:Int -> a+b} // the int types are inferred
val opration2 : (Int, Int) -> Int = {a,b -> a+b} // with type declaration

typealias Fun<A, B> = (A) -> B // function type

val multiplayBy2: Fun<Int, Int> = {x -> 2*x } // function type

 // type inferring practice :

val emptyLambda = {} // input: none , output: Unit aka () -> Unit

val helloLambda = {"Hello World!"} // () -> String

val helloThereLambda = {name: String -> "Hello $name"} // (String) -> String

val nothingLambda = { TODO("Do exercise more!") }  // () -> Nothing


