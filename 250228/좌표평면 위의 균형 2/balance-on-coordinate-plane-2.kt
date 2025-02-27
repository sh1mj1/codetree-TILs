
fun main() {
    val pointCount = readln().toInt()
    val points = List(pointCount) {
        readln().trim().split(" ").map(String::toInt).let {
            Point(it[0], it[1])
        }
    }

    val minX = points.minOf { it.x }
    val maxX = points.maxOf { it.x }
    val minY = points.minOf { it.y }
    val maxY = points.maxOf { it.y }

    val xRange = if (minX == maxX) listOf(minX / 2) else (minX + 1 .. maxX - 1).toList()
    val yRange = if (minY == maxY) listOf(minY / 2) else (minY + 1 .. maxY - 1).toList()

    val minPointsCount = xRange.minOf { x ->
        if (x % 2 != 0) return@minOf Int.MAX_VALUE

        yRange.minOf { y ->
            if (y % 2 != 0) return@minOf Int.MAX_VALUE

            val rightUpPointsCount = points.count { it.x > x && it.y > y }
            val leftUpPointsCount = points.count { it.x < x && it.y > y }
            val leftBottomPointsCount = points.count { it.x < x && it.y < y }
            val rightBottomPointsCount = points.count { it.x > x && it.y < y }

            listOf(
                rightUpPointsCount, 
                leftUpPointsCount,
                leftBottomPointsCount, 
                rightBottomPointsCount
            ).maxOf { it }
        }
    }
    println(
        minPointsCount
    )

}

data class Point(
    val x: Int,
    val y: Int,
) {

}