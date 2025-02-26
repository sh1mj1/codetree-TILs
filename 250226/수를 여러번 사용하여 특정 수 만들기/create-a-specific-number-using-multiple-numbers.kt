import kotlin.math.max

fun main() {
    val (a, b, c) = readln().trim().split(" ").map { it.toInt() }
    
    var answer = 0

    for (i in 0..c / a) {
        var count = i * a

        val numB = (c - count) / b
        count += numB * b

        answer = max(answer, count)
    }

    println(answer)
}