val NK = readln().split(" ").map { it.toInt() }
val n = NK[0]
val k = NK[1]

val numbers = readln().trim().split(" ").map { it.toInt() }

fun main() {
    println((numbers.sorted())[k-1])
}