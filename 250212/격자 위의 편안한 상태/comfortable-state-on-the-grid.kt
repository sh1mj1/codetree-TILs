

val nm = readln().split(" ").map(String::toInt)
val n = nm[0]
val m = nm[1]

val rowRange = 0 until n
val colRange = 0 until n

val grid = MutableList(n) {
    MutableList(n) { false }
}

val targets = List(m) {
    val target = readln().split(" ").map(String::toInt)
    Pair(target[0] - 1, target[1] - 1)
}

val directions = listOf(
    0 to 1,
    0 to -1,
    1 to 0,
    -1 to 0,
)

fun color(row: Int, col: Int) {
    grid[row][col] = true
}

fun isColored(row: Int, col: Int): Boolean = grid[row][col]

fun isComfortable(row: Int, col: Int): Boolean {
    var coloredAdjacentCount = 0

    for ((drow, dcol) in directions) {
        val nextRow = row + drow
        val nextCol = col + dcol

        if (nextRow in rowRange && nextCol in colRange) {
            if (isColored(nextRow, nextCol)) {
                coloredAdjacentCount++
            }
        }
        continue
    }
    return coloredAdjacentCount == 3
}

fun main() {
    targets.forEach { (row, col) ->
        color(row, col)
        if (isComfortable(row, col)) {
            println(1)
        } else {
            println(0)
        }
    }
}


