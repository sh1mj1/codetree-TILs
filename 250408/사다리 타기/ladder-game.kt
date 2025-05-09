import kotlin.math.min

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val lines = mutableListOf<Pair<Int, Int>>()
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        lines.add(Pair(b, a - 1))
    }
    // Please write your code here.
    val allRows = lines.map {
        Row(
            col1 = it.second,
            col2 = it.second + 1,
            height = it.first
        )
    }
        .sortedWith(compareBy({ it.height }, { it.col1 }))

    val ladderGame = LadderGame(
        playersCount = n,
        allRows = allRows,
    )

    ladderGame.play(
        depth = 0,
        removedRows = emptyList()
    )

    println(
        ladderGame.minRowsCount
    )
}

data class Row(
    val col1: Int,
    val col2: Int,
    val height: Int
)

class LadderGame(
    val playersCount: Int,
    val allRows: List<Row>,
) {
    val allRowsCount = allRows.size
    val originalPlayResult: List<Int> = playResult(rows = allRows)

    var minRowsCount = allRowsCount

    val visited = mutableSetOf<String>()
    
    fun playResult(rows: List<Row>) : List<Int>{
        val result = MutableList(playersCount) {idx -> idx}

        rows
            .forEach { row ->
                val (col1, col2, height) = row
                val temp = result[col1]
                result[col1] = result[col2]
                result[col2] = temp
            }

        return result
    }

    fun play(
        depth: Int,
        removedRows: List<Row>,
    ) {

        if (depth == allRowsCount) {
            val state = removedRows.joinToString(",")
            if (state in visited) return
            visited.add(state)

            val remainingRows = allRows - removedRows
            val playResult = playResult(rows = remainingRows)
            if (playResult == originalPlayResult) {
                minRowsCount = min(minRowsCount, remainingRows.size)
            }

            return
        }

        for (i in depth until allRowsCount) {
            play(
                depth = i + 1,
                removedRows = removedRows,
            )

            play(
                depth = i + 1,
                removedRows = removedRows + allRows[i]
            )
        }
    }
}
