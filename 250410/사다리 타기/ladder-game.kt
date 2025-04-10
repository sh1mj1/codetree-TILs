fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val lines = mutableListOf<Pair<Int, Int>>()
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        lines.add(Pair(b, a - 1))
    }
    // Please write your code here.
    val initialRows = lines.map {
        Row(
            col1 = it.second,
            col2 = it.second + 1,
            height = it.first,
        )
    }
        .sortedBy { it.height }

    fun playResult(rows: List<Row>): List<Int> {
        val result = MutableList(n) { idx -> idx }
        rows.forEach { row ->
            val (col1, col2, height) = row
            val temp = result[col1]
            result[col1] = result[col2]
            result[col2] = temp
        }
        return result
    }

    val initialPlayResult = playResult(rows = initialRows)

    if (initialPlayResult == List(n) { idx -> idx}) {
        println(0)
        return 
    }

    fun isValid(selectedRows: List<Row>): Boolean {
        val playResult = playResult(selectedRows)
        return initialPlayResult == playResult
    }

    fun firstValidCombination(
        selectedRows: List<Row>,
        startIdx: Int,
        countGoal: Int,
    ): List<Row> {
        if (selectedRows.size == countGoal) {
            if (isValid(selectedRows)) return selectedRows
            return emptyList()
        }

        for (idx in startIdx until m) {
            val newSelectedRows = selectedRows + initialRows[idx]
            val combination = firstValidCombination(
                selectedRows = newSelectedRows,
                startIdx = idx + 1,
                countGoal = countGoal,
            )
            if (combination.isEmpty()) continue
            return combination
        }
        return emptyList()
    }

    for (selectedCount in 1 until m) {
        val combination = firstValidCombination(
            emptyList(),
            0,
            selectedCount,
        )
        if (combination.isNotEmpty()) {
            println(combination.size)
            return
        }
    }
    println(m)
}



data class Row(
    val col1: Int,
    val col2: Int,
    val height: Int,
)