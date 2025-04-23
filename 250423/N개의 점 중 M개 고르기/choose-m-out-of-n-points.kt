

data class Point(
    val x: Int, 
    val y: Int,
) {
    fun distance(other: Point): Int {
        val xDiff = x - other.x
        val yDiff = y - other.y

        return (xDiff * xDiff) + (yDiff * yDiff)
    }
}

fun main() {
    val (n, m) = readln().trim().split(" ").map { it.toInt() }
    val points: List<Point> = List(n) {
        val (x, y) = readln().trim().split(" ").map { it.toInt() }
        Point(x, y)
    }
    // Please write your code here.
    fun combinations(n: Int, m: Int, src: List<Point>): List<List<Point>> {
        val combinations = mutableListOf<List<Point>>()

        fun add(s: Int, count: Int, combi: List<Point>) {
            if (count >= m) {
                combinations.add(combi)
                return
            }

            for (idx in s until src.size) {
                add(idx + 1, count + 1, combi + src[idx])
            }
        }

        add(0, 0, emptyList())

        return combinations
    }

    val nCm = combinations(n, m, points)
    
    val answer = nCm.minOf { sel ->
        val mC2 = combinations(m, 2, sel)
        mC2.minOf { 
            it[0].distance(it[1])
        }
    }

    println(answer)
}