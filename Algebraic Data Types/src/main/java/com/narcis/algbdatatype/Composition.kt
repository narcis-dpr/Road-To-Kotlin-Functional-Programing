typealias Fun<A, B> = (A) -> B

inline infix fun <A, B, C> Fun<B, C>.after(crossinline f: Fun<A, B>): Fun<A, C> =
  { a: A ->
    this(f(a))
  }

inline infix fun <A, B, C> Fun<A, B>.compose(crossinline g: Fun<B, C>): Fun<A, C> =
  { a: A ->
    g(this(a))
  }
