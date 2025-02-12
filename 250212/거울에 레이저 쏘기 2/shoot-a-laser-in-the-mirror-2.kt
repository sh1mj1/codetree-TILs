val n = readln().toInt()

val grid = List(n) {
    readln().toCharArray()
}

val startNumber = readln().toInt()

val directions = listOf(
    1 to 0, // DOWN
    0 to -1, // LEFT
    -1 to 0, // UP
    0 to 1, // RIGHT
)

val downStartRange = 1 .. n
val leftStartRange = n + 1 .. 2 * n
val upStartRange = 2 * n + 1 .. 3 * n
val rightStartRange = 3 * n + 1 .. 4 * n

val range = 0 until n

var num = 1
var row = 0
var col = 0
var dirIdx = 0

fun main() {
    setStartPosition()
    var count = 0

    while (inRange(row, col)) {
        count++
        shoot()
    }
    
    println(count)
}

fun setStartPosition() {
    when (startNumber) {
        in downStartRange -> {
            dirIdx = 0
            val seq = startNumber % n
            row = 0
            col = if (seq == 0) {
                n - 1
            } else {
                seq - 1
            }
        }

        in leftStartRange -> {
            dirIdx = 1
            val seq = startNumber % n
            col = n - 1
            row = if (seq == 0) {
                n - 1
            } else {
                seq - 1
            }
        }

        in upStartRange -> {
            dirIdx = 2
            val seq = startNumber % n
            row = n - 1
            col = if (seq == 0) {
                0
            } else {
                n - seq
            }
        }
        in rightStartRange -> {
            dirIdx = 3
            val seq = startNumber % n
            col = 0
            row = if (seq == 0) {
                0
            } else {
                n - seq
            }
        }
        else -> error("invalid startNumber")
    }
}

// 0: Down
// 1: Left
// 2: Up
// 3: Right

fun shoot() {
    when (dirIdx) {
        0 -> {
            if (grid[row][col] == '/') {
                col -= 1
                dirIdx = 1
            } else {
                col += 1
                dirIdx = 3
            }
        }
        1 -> {
            if (grid[row][col] == '/') {
                row += 1
                dirIdx = 0
            } else {
                row -= 1
                dirIdx = 2
            }
        }
        2 -> {
            if (grid[row][col] == '/') {
                col += 1
                dirIdx = 3
            } else {
                col -= 1
                dirIdx = 1
            }
        }
        3 -> {
            if (grid[row][col] == '/') {
                row -= 1
                dirIdx = 2
            } else {
                row += 1
                dirIdx = 0
            }
        }
        else -> error("invalid dirIdx: $dirIdx")
    }
}

fun inRange(r: Int, c: Int): Boolean = r in range && c in range