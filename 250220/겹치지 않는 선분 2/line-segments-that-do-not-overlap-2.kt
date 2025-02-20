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
        return (x1 <= other.x1 && x2 >= other.x2 ) || (x1 >= other.x1 && x2 <= other.x2)
    }
}
