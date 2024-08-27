import java.util.*

val sc = Scanner(System.`in`)

val x = sc.nextLong()
val y = sc.nextLong()
val z = sc.nextLong()

val multiplication: Long = x * y * z

fun f(num: Long): Long {
    if(num < 10) {
        return num
    }

    val quotient = num / 10
    val remainder = num % 10

    return remainder + f(quotient)
}

fun main() {
    println(f(multiplication))
}