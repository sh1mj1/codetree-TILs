import kotlin.math.max

fun main() {
    val gridSize = readLine()!!.toInt()
    val num = Array(gridSize) { readLine()!!.trim().split(" ").map { it.toInt() } }
    val moveDir = Array(gridSize) { readLine()!!.trim().split(" ").map { it.toInt() } }
    val (startRow, startCol) = readLine()!!.trim().split(" ").map { it.toInt() - 1 }
    // Please write your code here.

    val gridRange = 0 until gridSize

    data class Position(
        val row: Int,
        val col: Int,
    ) {
        val isInRange: Boolean = (row in gridRange) && (col in gridRange)

        fun movedWith(pos: Position): Position {
            return Position(
                row = row + pos.row,
                col = col + pos.col
            )
        }

        fun num(): Int = num[row][col]
    }

    val directions = mapOf(
        1 to Position(-1, 0),
        2 to Position(-1, 1),
        3 to Position(0, 1),
        4 to Position(1, 1),
        5 to Position(1, 0),
        6 to Position(1, -1),
        7 to Position(0, -1),
        8 to Position(-1, -1),
    )

    fun movableDestinations(direction: Position, position: Position): List<Position> {
        val curNum = position.num()
        val destinations = mutableListOf<Position>()

        var nextPosition = position.movedWith(direction)
        while (nextPosition.isInRange) {
            if (curNum < nextPosition.num()) {
                destinations.add(nextPosition)
            }
            nextPosition = nextPosition.movedWith(direction)
        }

        return destinations
    }

    fun moveCount(
        r: Int,
        c: Int,
    ): Int {
        val destinations = movableDestinations(
            direction = directions[moveDir[r][c]] ?: error(" "),
            Position(r, c)
        )
        if (destinations.isEmpty()) return 0

        return destinations.maxOf { dest ->
            1 + moveCount(dest.row, dest.col)
        }
    }

    println(moveCount(startRow, startCol))
}