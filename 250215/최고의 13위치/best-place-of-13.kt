import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val grid = List(n) {
        readln().trim().split(" ").map(String::toInt)
    }

    val window = SlidingWindow(0, 0)
    var count = window.count(grid)

    val range = 0 until n
    
    while (window.canMove(range)) {
        window.move(range)
        count = max(count, window.count(grid))
    }

    println(count)
}

data class SlidingWindow(
    var row: Int,
    var startCol: Int,
) {
    var endCol: Int = startCol + 2

    fun count(grid: List<List<Int>>): Int {
        return (startCol .. endCol).count { col ->
            grid[row][col] == 1
        }
    }

    fun canMove(range: IntRange): Boolean {
        if (endCol + 1 in range) {
            return true
        }
        if (row + 1 in range) {
            return true
        }
        return false
    }

    fun move(range: IntRange) {
        if (endCol + 1 in range) {
            moveCol()
            return
        }
        if (row + 1 in range) {
            moveRow()
        }
    }


    fun moveCol() {
        startCol++
        endCol++
    }

    fun moveRow() {
        row++
        startCol = 0
        endCol = startCol + 2
    }
    
}