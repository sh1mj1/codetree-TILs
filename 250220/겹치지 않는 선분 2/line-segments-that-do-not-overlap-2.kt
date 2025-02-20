

fun main() {
    val n = readln().toInt()

    val lines = List(n) {
        val (x1, x2) = readln().trim().split(" ").map(String::toInt)
        Line(Point(x1, 0),Point(x2, 1))
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
    val xIntercept: Int = p1.x

 fun isOverlapped(other: Line): Boolean {
    if (slope == other.slope) return false // 평행한 경우

    val intersectY = (other.xIntercept.toFloat() - xIntercept.toFloat()) / (slope - other.slope)

    if (intersectY <= 0 || intersectY >= 1) return false // y 값이 범위 내에 있어야 함

    val intersectX = xIntercept + slope * intersectY

    val minX1 = minOf(p1.x, p2.x)
    val maxX1 = maxOf(p1.x, p2.x)
    val minX2 = minOf(other.p1.x, other.p2.x)
    val maxX2 = maxOf(other.p1.x, other.p2.x)

    return intersectX in minX1..maxX1 && intersectX in minX2..maxX2
}

data class Point(
    val x: Int, 
    val y: Int,
)
