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

fun main() {
    var num = 1
    var row = 0
    var col = 0
    var dirIdx = 0
    
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

    var count = 0

    while (inRange(row, col)) {
        count++
        val (nextR, nextC, nextDirIdx) = shoot(row, col, dirIdx)

        row = nextR
        col = nextC
        dirIdx = nextDirIdx
    }
    
    println(count)
}

// 0: Down
// 1: Left
// 2: Up
// 3: Right

fun shoot(r: Int, c: Int, dirIdx: Int): Triple<Int, Int, Int> {
    when (dirIdx) {
        0 -> {
            if (grid[r][c] == '/') {
                return Triple(r, c - 1, 1)
            }
            return Triple(r, c + 1, 3)
        }
        1 -> {
            if (grid[r][c] == '/') {
                return Triple(r + 1, c, 0)
            }
            return Triple(r - 1, c, 0)
        }
        2 -> {
            if (grid[r][c] == '/') {
                return Triple(r, c + 1, 3)
            }
            return Triple(r, c - 1, 3)
        }
        3 -> {
            if (grid[r][c] == '/') {
                return Triple(r - 1, c, 2)
            }
            return Triple(r + 1, c, 0)
        }
        else -> error("invalid dirIdx: $dirIdx")
    }
}

fun inRange(r: Int, c: Int): Boolean = r in range && c in range