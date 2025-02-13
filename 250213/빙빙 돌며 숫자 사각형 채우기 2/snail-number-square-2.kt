val nm = readln().trim().split(" ").map { it.toInt() }
val rowCount = nm[0]
val colCount = nm[1]

val rowRange = 0 until rowCount
val colRange = 0 until colCount

val directions = listOf(
    1 to 0, // Down
    0 to 1, // Right
    -1 to 0, // Up
    0 to -1, // Left
)

var dir = 0
var row = 0
var col = 0
var num = 1

val grid = MutableList(rowCount) {
    MutableList(colCount) { 0 }
}

fun main() {
    while (num <= rowCount * colCount) {
        move()
    }

    rowRange.forEach { r ->
        colRange.forEach { c ->
            print("${grid[r][c]} ")
        }
        println()
    }

}


fun move() {
    when(dir) {
        // DOWN
        0 -> {
            grid[row][col] = num
            num++
            if (row + 1 in rowRange && grid[row + 1][col] == 0){
                row++
            } else {
                dir = 1
                col++
            }   
        }
        // RIGHT
        1 -> {
            grid[row][col] = num
            num++
            if (col + 1 in colRange && grid[row][col + 1] == 0){
                col++
            } else {
                dir = 2
                row--
            }
        }
        // UP
        2 -> {
            grid[row][col] = num
            num++
            if (row - 1 in rowRange && grid[row - 1][col] == 0){
                row--
            } else {
                dir = 3
                col--
            }
        }
        // LEFT
        3 ->  {
            grid[row][col] = num
            num++
            if (col - 1 in colRange && grid[row][col - 1] == 0) {
                col--
            } else {
                dir = 0
                row++
            }
        }
    }
}