import java.util.*

val sc = Scanner(System.`in`)

fun f(num: Int): Int {
    if(num < 10) {
        return num * num
    }

    val quotient = num / 10
    val remainder = num % 10

    return f(quotient) + remainder * remainder
}

fun main() {
    val N = sc.nextInt()
    println(f(N))
}