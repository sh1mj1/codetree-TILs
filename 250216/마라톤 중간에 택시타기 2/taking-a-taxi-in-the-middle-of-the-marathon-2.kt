import kotlin.math.abs
import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val points = List(n) {
        val (x, y) = readln().trim().split(" ").map(String::toInt)
        Point(x, y)
    }

    val answer = (1 .. n - 2).minOf { skipPoint ->
        points.filterIndexed { i, _ -> i != skipPoint }
              .zipWithNext { a, b -> a.distacne(b) }
              .sum()
    }

    println(
        answer
    )
}

data class Point(
    val x: Int,
    val y: Int,
) {
    fun distacne(other: Point): Int = abs(x - other.x) + abs(y - other.y)
}
