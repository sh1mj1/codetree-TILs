import kotlin.math.min
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val points = List(n) {
        readln().trim().split(" ").map(String::toInt).let {
            Point(it[0] , it[1])
        }
    }

    val areas = mutableListOf<Int>()


    for (skipped in points) {
        val currentPoints = points.filter { it != skipped }

        var minX = Int.MAX_VALUE
        var minY = Int.MAX_VALUE
        var maxX = Int.MIN_VALUE
        var maxY = Int.MIN_VALUE


        for (point in currentPoints) {
            minX = min(minX, point.x)
            minY = min(minY, point.y)
            maxX = max(maxX, point.x)
            maxY = max(maxY, point.y)
        }

        ((maxY - minY) * (maxX - minX)).let{
            areas.add(it)
        }
    }

    areas.minOf { it }.let(::println)
}


data class Point(
    val x: Int,
    val y: Int,
)