import kotlin.math.abs
import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val points = List(n) {
        val (x, y) = readln().trim().split(" ").map(String::toInt)
        Point(x, y)
    }

    var shortestDistance = Int.MAX_VALUE

    for (skipPoint in 1 .. n - 2) {
        var currentShortDistance = 0
        
        var i = 0
        while (i in 0 .. n - 2) {
            if (i + 1 == skipPoint) {
                val current = points[i].distacne(points[i + 2])
                currentShortDistance += current
                i += 2
                continue
            }
            val current = points[i].distacne(points[i + 1])
            currentShortDistance += current
            i++
        }
        shortestDistance = min(currentShortDistance, shortestDistance)
    }

    println(
        shortestDistance
    )
}

data class Point(
    val x: Int,
    val y: Int,
) {
    fun distacne(other: Point): Int = abs(x - other.x) + abs(y - other.y)
}
