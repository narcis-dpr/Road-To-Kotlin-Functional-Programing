package com.narcis.expressionevaluationlaziness

import kotlin.reflect.KProperty

fun testDelegate() {
var variable by object { // delegate to an object with getter and setter operator function
    var localInt: Int? = null
    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>,
    ): Int? {
        println("Getter Invoked returining $localInt")
        return localInt
    }
    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: Int?
    ) {
        println("setter invoked with value $value")
        localInt = value
    }
}
    variable = 10
    println("reading $variable")
}


fun main() {
    testDelegate()

    val inputeValue = 30
    val greater10 by lazy { greaterThan10(inputeValue) } // delegate the access to the greater10 variable to the object you get by invoking lazy

    if (inputeValue > 4 && greater10) {
        println("ok")
    } else {
        println("ko")
    }
}