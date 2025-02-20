fun main() {
    val n = readln().toInt()

    val lines = List(n) {
        val (x1, x2) = readln().trim().split(" ").map(String::toInt)
        Line(x1, x2)
    }

    lines.count { standard ->
        lines.any {
            it != standard && standard.isOverlapped(it)
        }
    }.let(::println)
}

data class Line(
    val x1: Int,
    val x2: Int,
) {
    fun isOverlapped(other: Line): Boolean {
        val minX1 = minOf(x1, x2)
        val maxX1 = maxOf(x1, x2)
        val minX2 = minOf(other.x1, other.x2)
        val maxX2 = maxOf(other.x1, other.x2)

    return (minX1 <= minX2 && maxX1 >= maxX2) || (minX1 >= minX2 && maxX1 <= maxX2)
    }
}
