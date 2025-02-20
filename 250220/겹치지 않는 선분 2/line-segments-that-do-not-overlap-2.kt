import kotlin.math.abs

fun main() {
    val n = readln().toInt()

    val lines = List(n) {
        val (x1, x2) = readln().trim().split(" ").map(String::toInt)
        val (start, end) = if (x1 <= x2) x1 to x2 else x2 to x1
        Line(Point(start, 0), Point(end, 1))
    }

    lines.count { stand ->
        lines
            .filter { it != stand }
            .any { it.isOverlapped(stand) }
    }.let(::println)
}

data class Line(
    val p1: Point,
    val p2: Point
) {
    val slope: Float = (p2.x - p1.x).toFloat()
    val xIntercept: Int = p1.x

    fun isOverlapped(other: Line): Boolean {
        if (slope == other.slope) return false

        val overlappedPointY = (other.xIntercept.toFloat() - xIntercept.toFloat()) / (slope - other.slope)

        return overlappedPointY > 0.0 && overlappedPointY < 1
    }
}

data class Point(
    val x: Int, 
    val y: Int,
)