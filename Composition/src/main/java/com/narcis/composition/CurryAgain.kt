package com.narcis.composition


// not a pure fun (not referentially transparent):
fun functionWithAnotherEffect(x: Int): String {
    val result = x * x - 1

    return "Result: $result calculated on ${System.currentTimeMillis()}"
}

// make it pure :
fun functionWithAnotherEffectPure(time: Long, x: Int): String {
    val result = x * x - 1

    return "Result: $result calculated on $time"
}
fun main() {
    functionWithAnotherEffect(5) pipe ::println
    functionWithEffect(5) pipe ::println

    // pure version :
    functionWithAnotherEffectPure(123L,5) pipe ::println
    functionWithAnotherEffectPure(123L,5) pipe ::println

    val forTesting = 123L pipe ::functionWithAnotherEffectPure.curry()

    forTesting(5) pipe ::println
    forTesting(5) pipe ::println
}