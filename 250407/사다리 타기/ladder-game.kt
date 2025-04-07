data class Line(val row: Int, val col: Int)

class LadderGame(
    private val verticalCount: Int,
    private val horizontalCount: Int,
    lines: List<Line>
) {
    private val connections: List<MutableList<Int>> = List(verticalCount) { mutableListOf() }
    private val originalOrder: List<Int>

    init {
        lines.forEach { (row, col) ->
            connections[col].add(row)
        }
        originalOrder = (0 until verticalCount).toList()
    }

    private fun move(start: Int): Int {
        var position = start
        for (x in 0 until 16) {
            if (position < verticalCount - 1 && x in connections[position]) position++
            else if (position > 0 && x in connections[position - 1]) position--
        }
        return position
    }

    fun isValid(): Boolean {
        return (0 until verticalCount).all { move(it) == it }
    }

    fun findMaxRemovableLines(removed: List<Int>, current: Int): Int {
        if (current == horizontalCount) {
            return if (isValid()) removed.size else 0
        }

        val withRemoval = findMaxRemovableLines(removed + current, current + 1)
        val withoutRemoval = findMaxRemovableLines(removed, current + 1)

        return maxOf(withRemoval, withoutRemoval)
    }
}

fun main() {
    val (verticalCount, horizontalCount) = readln().split(" ").map { it.toInt() }
    val lines = mutableListOf<Line>()
    repeat(horizontalCount) {
        val (row, col) = readln().split(" ").map { it.toInt() - 1 }
        lines.add(Line(row, col))
    }

    val game = LadderGame(verticalCount, horizontalCount, lines)
    val result = game.findMaxRemovableLines(emptyList(), 0)
    println(result)
}