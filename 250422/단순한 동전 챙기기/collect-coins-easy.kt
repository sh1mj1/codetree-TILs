import kotlin.math.abs

data class Pos(
    val row: Int,
    val col: Int,
    val value: Int,
) {
    fun distance(other: Pos): Int =  abs(row - other.row) + abs(col - other.col)
    
}

fun main() {
    val gridSize = readLine()!!.toInt()
    val grid: List<List<Pos>> = (0 until gridSize).map { r ->
        val line = readLine()!!
        line.mapIndexed { c, v ->
            when (v) {
                '.' -> Pos(r, c, 0)
                'S' -> Pos(r, c, -1)
                'E' -> Pos(r, c, -2)
                else -> Pos(r, c, v.digitToInt())
            }
        }
    }

    fun coins(): List<Pos> {
        return grid.flatMap { row ->
            row.filter { it.value > 0 }
        }.sortedBy { it.value }
    }

    val coins: List<Pos> = coins()
    val coinsSize = coins.size

    if (coins.size < 3) {
        println(-1)
        return
    }

    fun combinations(n: Int, m: Int): List<List<Pos>> {
        val combinations = mutableListOf<List<Pos>>()
        
        fun add(sIdx: Int, curCombi: List<Pos>) {
            if (curCombi.size == m) {
                combinations.add(curCombi)
                return
            }

            for (idx in sIdx until coinsSize) {
                add(idx + 1, curCombi + coins[idx])
            }
        }

        add(0, emptyList())
        return combinations
    }

    val flattenGrid = grid.flatMap { it }

    val start = flattenGrid.first { it.value == -1 }
    val end = flattenGrid.first { it.value == -2 }

    val combinations = combinations(coinsSize, 3).map { listOf(start) + it + end}


    fun distance(combination: List<Pos>): Int {
        return combination.zipWithNext { pos1, pos2 ->
            pos1.distance(pos2)
        }.sum()
    }

    println(
        combinations.minOf {
            distance(it)
        }
    )
}
