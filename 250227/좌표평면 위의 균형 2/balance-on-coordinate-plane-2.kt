import kotlin.math.max
import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val points = List(n) { readln().split(" ").map { it.toInt() } }

    var answer = Int.MAX_VALUE

    for (i in 0..100 step 2) {
        for (j in 0..100 step 2) {
            var num1 = 0
            var num2 = 0
            var num3 = 0
            var num4 = 0

            for ((x, y) in points) {
                when {
                    x < i && y > j -> num1++
                    x > i && y > j -> num2++
                    x > i && y < j -> num3++
                    else -> num4++
                }
            }

            val maxNum = maxOf(num1, num2, num3, num4)
            answer = min(answer, maxNum)
        }
    }

    println(answer)
}