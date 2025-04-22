import kotlin.math.abs

fun main() {
    val gridSize = readln().toInt()
    val grid: List<List<Int>> = List(gridSize) {
        val line = readLine()!!
        // -1: 출발, -2: 도착
        line.map {
            if (it == '.') {
                0
            } else if (it == 'S') {
                -1
            } else if (it == 'E') {
                -2
            } else {
                it.digitToInt()
            }
        }
    }

    data class Pos(
        val row: Int,
        val col: Int,
        val value: Int,
    )

    val coins = grid.flatMapIndexed { rowIndex, row ->
        row.mapIndexedNotNull { colIndex, col ->
            if (col > 0) {
                return@mapIndexedNotNull Pos(rowIndex, colIndex, col)
            } else {
                return@mapIndexedNotNull null
            }
        }
    }.sortedBy { it.value }

    if (coins.size < 3) {
        println(-1)
        return
    }

    fun combinations(n: Int, m: Int): List<List<Pos>> {
        val combinations = mutableListOf<List<Pos>>()

        fun add(coinStartIdx: Int, curCombi: List<Pos>) {
            if (curCombi.size == m) {
                combinations.add(curCombi)
                return
            }

            for (coinIdx in coinStartIdx until coins.size) {
                add(coinIdx + 1, curCombi + coins[coinIdx] )
            }
        }

        add(0, emptyList())

        return combinations
    }

    val combinations = combinations(coins.size, 3)

    var start: Pos = Pos(0, 0, 0)
    var end: Pos = Pos(0, 0, 0)
    
    (0 until gridSize).forEach { row ->
        (0 until gridSize).forEach { col ->
            if (grid[row][col] == -1) {
                start = Pos(row, col, grid[row][col])
            }
            if (grid[row][col] == -2) {
                end = Pos(row, col, grid[row][col])
            }
        }
    }
    

    fun routeSize(combination: List<Pos>): Int {
        val com = (listOf(start) + combination + end)
        var result = 0

        for (idx in 1 until com.size) {
            val diff = abs(com[idx].row - com[idx - 1].row) + abs(com[idx].col - com[idx - 1].col)
            result += diff
        }

        return result
    }

    val answer = combinations.minOf {
        routeSize(it)
    }

    println(answer)
    

    



}