package com.example.state


typealias Fun<A,B> = (A) -> B
infix fun <A,B> A.pipe(fn: Fun<A,B>): B = fn(this)