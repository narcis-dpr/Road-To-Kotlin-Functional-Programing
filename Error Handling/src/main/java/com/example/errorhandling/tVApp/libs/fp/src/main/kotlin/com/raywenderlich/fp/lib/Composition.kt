
package com.example.errorhandling.tVApp.libs.fp.src.main.kotlin.com.raywenderlich.fp.lib

/** Implement composition using g after f notation. */
inline infix fun <A, B, C> Fun<B, C>.after(crossinline f: Fun<A, B>): Fun<A, C> =
  { a: A ->
    this(f(a))
  }

/** Compose two functions */
inline infix fun <A, B, C> Fun<A, B>.compose(crossinline g: Fun<B, C>): Fun<A, C> =
  { a: A ->
    g(this(a))
  }
