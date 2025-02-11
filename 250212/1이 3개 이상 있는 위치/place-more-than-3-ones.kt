

fun main() {
    val n = readln().toInt()
    val grid = List(n) {
        readln().trim().split(" ").map { it.toInt() }
    }
    val range = 0 until n
    val directions = listOf(
        1 to 0, // DOWN
        0 to -1, // LEFT
        -1 to 0, // UP
        0 to 1, // RIGHT
    )

    var count = 0

    for (r in range) {
        for (c in range) {
            var currentCount = 0
            for (dir in directions) {
                val currentR = r + dir.first
                val currentC = c + dir.second

                if (currentR !in range) continue
                if (currentC !in range) continue
                
                if (grid[currentR][currentC] == 1) {
                    currentCount++
                }
            }
            if (currentCount >= 3) count++
        }
    }
    println(count)
}

