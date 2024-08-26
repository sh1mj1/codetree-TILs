import java.util.*

val sc = Scanner(System.`in`)

fun factorial(num: Int): Int =
    when(num) {
        0 -> 1
        1 -> 1
        2 -> 2
        else -> factorial(num-1) * num
    }

fun main() {
    val N = sc.nextInt()
    println(factorial(N))
}