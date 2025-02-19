import kotlin.math.pow
import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val points = List(n) {
        val (x, y) = readln().trim().split(" ").map(String::toInt)
        x to y
    }

    var minDist2 = Int.MAX_VALUE

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val (x1, y1) = points[i]
            val (x2, y2) = points[j]
            val dist2 = (x1 - x2).toDouble().pow(2).toInt() + (y1 - y2).toDouble().pow(2).toInt()
            minDist2 = min(minDist2, dist2)
        }
    }

    println(minDist2)
}