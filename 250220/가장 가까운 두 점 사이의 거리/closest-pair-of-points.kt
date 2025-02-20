fun main() {
    val n = readln().toInt()
    val points = List(n) {
        val (x, y) = readln().trim().split(" ").map(String::toInt)
        Point(x, y)
    }

    val minimumDistance = points.minOf { startPoint ->
        points
            .filter { it != startPoint }
            .minOf { targetPoint -> startPoint.distance(targetPoint) }
    }

    minimumDistance.let(::println)

}
data class Point(
    private val x: Int,
    private val y: Int,
){

    fun distance(other: Point): Int {
        val xDiff = x - other.x
        val yDiff = y - other.y

        return xDiff * xDiff + yDiff * yDiff
    }
}
