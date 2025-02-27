

fun main() {
    val pointCount = readln().toInt()
    val points = List(pointCount) {
        readln().trim().split(" ").map(String::toInt).let { (x, y) -> Point(x, y) }
    }

    if (
        canCoverInLines(
            points = points,
            remainLineCount = 3,
            directions = Direction.values().toList(),
        )
    ) {
        println(1)
    } else {
        println(0)
    }
    
}

fun canCoverInLines(points: List<Point>, remainLineCount: Int, directions: List<Direction>): Boolean {
    if (points.isEmpty()) return true
    if (remainLineCount == 0) return false

    return points.any { point -> 
        directions.any { direction -> 
            val remain = points.filterNot { it.isAlignedWith(point, direction)}
            canCoverInLines(remain, remainLineCount - 1, directions)
        }
    }
}


enum class Direction {
    X,
    Y;

    fun isAligned(point1: Point, point2: Point): Boolean = when(this) {
        X -> point1.y == point2.y
        Y -> point1.x == point2.x
    }
}

data class Point(
    val x: Int,
    val y: Int,
) {
    fun isAlignedWith(other: Point, direction: Direction): Boolean = direction.isAligned(this, other)
}
