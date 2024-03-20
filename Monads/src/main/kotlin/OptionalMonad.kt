import kotlin.math.sqrt


fun strToInt(str: String): Int = str.toInt()

fun strToInt2(str: String): Optional<Int> = try {
    Optional.lift(str.toInt())
} catch (nfe: NumberFormatException) {
    None
}

fun root(number: Int): Optional<Double> =
    if (number < 0) None else Optional.lift(sqrt(number.toDouble()))

fun main() {
    strToInt("123") pipe ::println
    strToInt("onetwothree") pipe ::println // since the strToInt is partial it will not work on this
    val strToRoot = ::strToInt
}



sealed class Optional <out T> { // this class has a type parameter and its covariant
    companion object {
        @JvmStatic
        fun <T> lift(value: T): Optional<T> = Some(value) // allows you to get Optional<T> from given value of type T

        @JvmStatic
        fun <T> empty(): Optional<T> = None
    }
}
object None: Optional<Nothing>() // the case of container is empty
data class Some<T>(val value: T): Optional<T>()