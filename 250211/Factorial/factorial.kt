
fun main() {
    val n = readln().toInt()
    println(
        factorial(n)
    )
}

fun factorial(n: Int): Int {
    if (n == 1) return 1
    return n * factorial(n - 1)
}