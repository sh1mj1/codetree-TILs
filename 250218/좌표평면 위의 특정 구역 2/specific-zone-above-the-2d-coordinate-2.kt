import kotlin.math.min
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val points = List(n) {
        readln().trim().split(" ").map(String::toInt).let {
            Point(it[0] , it[1])
        }
    }

    points.minOf { skipped ->
        var minX = Int.MAX_VALUE
        var minY = Int.MAX_VALUE
        var maxX = Int.MIN_VALUE
        var maxY = Int.MIN_VALUE
        
        points.filter { it != skipped }.forEach { point ->
            minX = min(minX, point.x)
            minY = min(minY, point.y)
            maxX = max(maxX, point.x)
            maxY = max(maxY, point.y)
        }

        (maxY - minY) * (maxX - minX)
    }.let(::println)

}

data class Point(
    val x: Int,
    val y: Int,
)
