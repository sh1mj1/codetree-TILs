val nm = readln().trim().split(" ").map { it.toInt() }
val n = nm[0]
val m = nm[1]

val rowRange = 0 until n
val colRange = 0 until m

val grid = MutableList(n) {
    MutableList(m) { 0 }
}


fun main() {
    val point = Point(
        row = 0,
        col = 0
    )

    point.writeAll()

    rowRange.forEach { row -> 
        colRange.forEach { col -> 
            print("${grid[row][col]} ")
        }
        println()
    }
}

data class Point(
    private var row: Int,
    private var col: Int,
) {
    private var dirIdx = 0

    fun writeAll() {
        var num = 1
        val maxNum = n * m

        while (true) {
            grid[row][col] = num

            if (num >= maxNum) return
            
            val nextRow = row + directions[dirIdx]!!.first
            val nextCol = col + directions[dirIdx]!!.second

            if (inRange(nextRow, nextCol) && !numberIsExisted(nextRow, nextCol)) {
                row = nextRow
                col = nextCol
            } else {
                swithDirection() 
                row = row + directions[dirIdx]!!.first
                col = col + directions[dirIdx]!!.second
            }

            num++
        } 
    }

    fun inRange(r: Int, c: Int): Boolean = r in rowRange && c in colRange

    fun numberIsExisted(r: Int, c: Int): Boolean = grid[r][c] != 0

    fun swithDirection() {
        dirIdx += 1
        if (dirIdx >= 4) {
            dirIdx -= 4
        }
    }

    companion object {
        val directions = listOf(
            0 to 1, // RIGHT
            1 to 0, // DOWN
            0 to -1, // LEFT
            -1 to 0, // UP
        )
    }
}

