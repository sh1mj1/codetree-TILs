import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val num = Array(n) { readLine()!!.split(" ").map { it.toInt() } }
    val moveDir = Array(n) { readLine()!!.split(" ").map { it.toInt() } }
    val (startRow, startCol) = readLine()!!.split(" ").map { it.toInt() - 1 }
    // Please write your code here.
    var maxMoveCount = 0
    data class Position(
        val row: Int,
        val col: Int,
    )

    fun inRange(r: Int, c: Int): Boolean = (r in 0 until n) && (c in 0 until n)

    fun movableDestinations(direction: Int, r: Int, c: Int): List<Position> {
        val curNum = num[r][c]
        var curRow = r
        var curCol = c
        val next = mutableListOf<Position>()

        when(direction) {
            // up
            1 -> {
                while (inRange(--curRow, curCol)) {
                    if (curNum < num[curRow][curCol]) {
                        next.add(Position(curRow, curCol))
                    }
                }
            }
            // rightup
            2 -> {
                while (inRange(--curRow, ++curCol)) {
                    if (curNum < num[curRow][curCol]) {
                        next.add(Position(curRow, curCol))
                    }
                }
            }
            // right
            3 -> {
                while (inRange(curRow, ++curCol)) {
                    if (curNum < num[curRow][curCol]) {
                        next.add(Position(curRow, curCol))
                    }
                }
            }
            // rightdown
            4 -> {
                while (inRange(++curRow, ++curCol)) {
                    if (curNum < num[curRow][curCol]) {
                        next.add(Position(curRow, curCol))
                    }
                }
            }
            // down
            5 -> {
                while (inRange(++curRow, curCol)){
                    if (curNum < num[curRow][curCol]) {
                        next.add(Position(curRow, curCol))
                    }
                }
            }
            // left down
            6 -> {
                while (inRange(++curRow, --curCol)){
                    if (curNum < num[curRow][curCol]) {
                        next.add(Position(curRow, curCol))
                    }
                }
            }
            // left
            7 -> {
                while (inRange(curRow, --curCol)){
                    if (curNum < num[curRow][curCol]) {
                        next.add(Position(curRow, curCol))
                    }
                }
            }
            // leftUp: 
            8 -> {
                while (inRange(--curRow, --curCol)){
                    if (curNum < num[curRow][curCol]) {
                        next.add(Position(curRow, curCol))
                    }
                }
            }
        }
        return next
    }

    fun move(
        moveCount: Int,
        r: Int,
        c: Int,
    ) {
        val destinations = movableDestinations(
            direction = moveDir[r][c],
            r = r,
            c = c,
        )
        if (destinations.isEmpty()) {
            maxMoveCount = max(maxMoveCount, moveCount)
            return 
        }

        for (destination in destinations) {
            move(
                moveCount = moveCount + 1,
                r = destination.row,
                c = destination.col,
            )
        }
    }

    move(
        moveCount = 0,
        r = startRow,
        c = startCol,
    )

    println(maxMoveCount)
}