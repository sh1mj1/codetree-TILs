val nm = readln().trim().split(" ").map(String::toInt)

val rowCount = nm[0]
val colCount = nm[1]

val rowRange = 0 until rowCount
val colRange = 0 until colCount

val maxNum = rowCount * colCount
var num = 0
var char = 'A'
var row = 0
var col = 0
var dir = 0

val directions = listOf(
    // right
    0 to 1,
    // down
    1 to 0,
    // left
    0 to -1,
    // up
    -1 to 0,
)

val grid = MutableList(rowCount) {
    MutableList(colCount) { 'a' }
}

fun main() {
    while (num < maxNum) {
        move()
    }
    rowRange.forEach { r -> 
        colRange.forEach { c -> 
            print("${grid[r][c]} ")
        }
        println()
    }
}

val charRange = 'A' .. 'Z'

fun move() {
    grid[row][col] = char
    num++

    if (char == 'Z') {
        char = 'A'
    } else {
        char = (char.toInt() + 1).toChar()
    }

    when(dir) {
        // right
        0 -> {
            if (col + 1 in colRange && grid[row][col + 1] == 'a') {
                col++
            } else {
                dir = 1
                row++
            }
        }
        // down
        1 -> {
            if (row + 1 in rowRange && grid[row + 1][col] == 'a') {
                row++
            } else {
                dir = 2
                col--
            }
        }
        // left
        2 -> {
            if (col - 1 in colRange && grid[row][col - 1] == 'a') {
                col--
            } else {
                dir = 3
                row--
            }
        }

        // up
        3 -> {
            if (row - 1 in rowRange && grid[row - 1][col] == 'a') {
                row--
            } else {
                dir = 0
                col++
            }
        }
    }
}

