import kotlin.math.abs

fun main() {
    val n = readln().toInt()

    val points = List(n) {
        val (x, y) = readln().trim().split(" ").map(String::toInt)
        Point(x, y)
    }

    val triangles = points.flatMap { p1 ->
        points.flatMap { p2 ->
            points.map { p3 ->
                Triangle(p1, p2, p3)
            }
        }
    }.toSet()

    triangles.map { triangle ->
        triangle.baseLine() * triangle.height()
    }
    .maxOf { it }
    .let(::println)
}

data class Triangle(
    val p1: Point,
    val p2: Point,
    val p3: Point,
) {

    fun baseLine(): Int {
        if (p1.parallelWithX(p2)) return abs(p1.x - p2.x)
        if (p1.parallelWithX(p3)) return abs(p1.x - p3.x)
        if (p2.parallelWithX(p3)) return abs(p2.x - p3.x)
        return 0
    }

    fun height(): Int {
        if (p1.parallelWithY(p2)) return abs(p1.y - p2.y)
        if (p1.parallelWithY(p3)) return abs(p1.y - p3.y)
        if (p2.parallelWithY(p3)) return abs(p2.y - p3.y)
        return 0
    }

}

data class Point(
    val x: Int,
    val y: Int,
) {

    fun parallelWithX(other: Point): Boolean = y - other.y == 0

    fun parallelWithY(other: Point): Boolean = x - other.x == 0

}