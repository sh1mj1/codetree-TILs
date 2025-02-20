

fun main() {
    val n = readln().toInt()

    val lines = List(n) {
        val (x1, x2) = readln().trim().split(" ").map(String::toInt)
        Line(Point(x1, 0),Point(x2, 0))
    }

    lines.count { stand ->
        lines
            .filter { it != stand}
            .any { it.isOverlapped(stand) }
    }.let(::println)
}

data class Line(
    val p1: Point,
    val p2: Point
) {
    val slope: Float = p2.x.toFloat() - p1.x.toFloat()
    val yIntercept: Int = p1.x

    fun isOverlapped(other: Line): Boolean {
        if (slope == other.slope) return false

        val overlappedPointY = (other.yIntercept.toFloat() - yIntercept.toFloat()) / (slope - other.slope)

        return overlappedPointY >= 0.0 && overlappedPointY <= 1
    }
}

data class Point(
    val x: Int, 
    val y: Int,
)
