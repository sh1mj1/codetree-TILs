
val n = readln().toInt()
val maxNum = n * n

var r = n / 2
var c = n / 2

var num = 1
var dirIdx = 0


val range = 0 until n

val grid = MutableList(n) {
    MutableList(n) { 0 }
}

var dirCount = 0
var count = 0
var cur = count

fun main() {
    writeAll()

    range.forEach { row -> 
        range.forEach { col -> 
            print("${grid[row][col]} ")
        }
        println()
    }
}


fun writeAll() {
    while (num <= maxNum && inRange()) {
        if (dirCount % 2 == 0) {
            count++
        }
        cur = count
        
        when (dirIdx) {
            // RIGHT
            0 -> {
                while (cur > 0 && inRange()) {
                    grid[r][c++] = num++
                    cur--
                }
                dirCount++
                dirIdx = 1
            }

            // UP
            1 -> {
                while (cur > 0 && inRange()) {
                    grid[r--][c] = num++
                    cur--
                }
                dirCount++
                dirIdx = 2
            }

            // LEFT
            2 -> {
                while (cur > 0 && inRange()) {
                    grid[r][c--] = num++
                    cur--
                }
                dirCount++
                dirIdx = 3
            }

            // DOWN
            3 -> {
                while (cur > 0 && inRange()) {
                    grid[r++][c] = num++
                    cur--
                }
                dirCount++
                dirIdx = 0
            }
        }
    }

}

fun inRange(): Boolean = r in range && c in range