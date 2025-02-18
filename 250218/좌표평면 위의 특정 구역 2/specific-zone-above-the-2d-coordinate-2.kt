

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
val minX = currentPoints.minOf { it.x }
        val maxX = currentPoints.maxOf { it.x }
        val minY = currentPoints.minOf { it.y }
        val maxY = currentPoints.maxOf { it.y }

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