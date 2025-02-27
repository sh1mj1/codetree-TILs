fun main() {
    val pointCount = readln().toInt()
    val points = List(pointCount) {
        readln().trim().split(" ").map(String::toInt).let {
            Point(it[0], it[1])
        }
    }

    val directions = listOf('x', 'y')

    if (canCoverIn3Lines(points, directions)) println(1)
    else println(0)
}

fun canCoverIn3Lines(points: List<Point>, directions: List<Char>): Boolean {
    for (p1 in points) {
        for (dir1 in directions) {
            val remain1 = points.filter(p1, dir1)
            if (remain1.isEmpty()) return true

            for (p2 in remain1) {
                for (dir2 in directions) {
                    val remain2 = remain1.filter(p2, dir2)
                    if (remain2.isEmpty()) return true

                    for (p3 in remain2) {
                        for (dir3 in directions) {
                            val remain3 = remain2.filter(p3, dir3)
                            if (remain3.isEmpty()) return true
                            continue
                        }
                    }
                }
            }
        }
    }
    return false
}

private fun List<Point>.filter(target: Point, direction: Char): List<Point> {
    return if (direction == 'x') {
        this.filter { it.y != target.y}
    } else {
        this.filter { it.x != target.x}
    }
}


data class Point(
    val x: Int, 
    val y: Int,
)