
package com.example.errorhandling.tVApp.libs.fp.src.main.kotlin.com.raywenderlich.fp.lib

/** Any function from A to B */
typealias Fun<A, B> = (A) -> B

/** A simple function to push a value into a function */
infix fun <A, B> A.pipe(f: Fun<A, B>): B = f(this)

/** A simple function to push a value into a function from the right */
infix fun <A, B> Fun<A, B>.epip(a: A): B = this(a)