

typealias M<T> = List<T>
typealias Fun<A, B> = (A) -> B
infix fun <A, B, C> Fun<A, M<B>>.fish(
    g: Fun<B, M<C>>
): (A) -> M<C> = { a: A ->
    val mb: M<B> = this(a)
    mb.bind(g)
}

infix fun <B, C> M<B>.bind(
    g: Fun<B, M<C>>
): M<C> {
    TODO()
}

interface Monad<T> {
    fun lift(value: T): Monad<T>
    fun <B> bind(g: Fun<T, M<B>>): Monad<B>
}