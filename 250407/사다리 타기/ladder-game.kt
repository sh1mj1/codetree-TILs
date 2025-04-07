fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val lines = mutableListOf<Pair<Int, Int>>()
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        lines.add(Pair(b, a - 1))
    }

    val board = Array(16) { IntArray(12) }
    var answer = 100
    val linesToRemove = mutableListOf<Pair<Int, Int>>()
    var originResult = listOf<Int>()

    fun makeBoard() {
        for (i in board.indices) board[i].fill(0)

        for ((x, y) in lines) {
            board[x][y] = 1
            board[x][y + 1] = 2
        }

        for ((x, y) in linesToRemove) {
            board[x][y] = 0
            board[x][y + 1] = 0
        }
    }

    fun play(): List<Int> {
        makeBoard()
        val result = MutableList(n) { 0 }

        for (player in 0 until n) {
            var x = 0
            var y = player

            while (x < 16) {
                if (board[x][y] == 1 && y + 1 < n && board[x][y + 1] == 2) {
                    y++
                } else if (board[x][y] == 2 && y - 1 >= 0 && board[x][y - 1] == 1) {
                    y--
                }
                x++
            }
            result[y] = player
        }
        return result
    }

    fun isPossible(result: List<Int>): Boolean {
        return result == originResult
    }

    fun findMinLines(idx: Int) {
        if (idx == m) {
            val result = play()
            if (isPossible(result)) {
                val lineCount = m - linesToRemove.size
                answer = minOf(answer, lineCount)
            }
            return
        }
        linesToRemove.add(lines[idx])
        findMinLines(idx + 1)

        linesToRemove.removeLastOrNull()
        findMinLines(idx + 1)
    }

    originResult = play()
    findMinLines(0)
    println(answer)
}
