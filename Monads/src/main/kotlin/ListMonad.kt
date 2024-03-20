fun <T> List<List<T>>.listFlatten(): List<T> = this.fold(mutableListOf()) { acc, item ->
    acc.apply {
        addAll(item)
    }
}

infix fun <B, C> List<B>.listBind(
    g: Fun<B, List<C>>
): List<C> = map(g).listFlatten()

infix fun <A, B, C> Fun<A, List<B>>.listFish(
    g: Fun<B, List<C>>
): Fun<A, List<C>> = { a: A ->
    this(a).listBind(g)
}

val countList: (Int) -> List<Int> = { n: Int -> List(n) { it + 1 } }

val intToChars = {n: Int -> List(n) {'a' + n} }

fun main() {
    val fished = countList listFish intToChars
    fished(3) pipe ::println

    countList(3).flatMap(intToChars) pipe ::println

}

infix fun <A,B> A.pipe(f: Fun<A, B>): B = f(this)