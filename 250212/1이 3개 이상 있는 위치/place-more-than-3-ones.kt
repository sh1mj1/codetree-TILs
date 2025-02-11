
val n = readln().toInt()
val grid = List(n) {
    readln().trim().split(" ").map { it.toInt() }
}
val range = 0 until n
val directions = listOf(
    1 to 0,  // DOWN
    0 to -1, // LEFT
    -1 to 0, // UP
    0 to 1   // RIGHT
)    

fun main() {
    val count = range.flatMap { row ->
        range.map { col ->
            directions.count { (dRow, dCol) ->
                val next = Point(row + dRow, col + dCol)
            
                next.isIn(range) && next.is1(grid)
            }
        }
    }.count { it >= 3 }

    println(count)
}

data class Point(
    val row: Int,
    val col: Int,
) {
    fun isIn(range: IntRange): Boolean = row in range && col in range

    fun is1(grid: List<List<Int>>): Boolean = grid[row][col] == 1
}