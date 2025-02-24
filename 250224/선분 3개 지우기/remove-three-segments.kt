fun main() {
    val lineCount = readln().toInt()
    val lines = List(lineCount) {
        readln().trim().split(" ").map(String::toInt).let { Line(it[0], it[1]) }
    }

    val combinationsCount = (0 until lineCount - 2).sumOf { i1 ->
        (i1 + 1 until lineCount - 1).sumOf { i2 ->
            (i2 + 1 until lineCount).count { i3 ->
                val remainedLines = lines.filterIndexed { index, _ -> index != i1 && index != i2 && index != i3 }

                remainedLines.all { line1 ->
                    remainedLines.all { line2 -> line1 == line2 || !line1.isOverlapped(line2) }
                } 
            }
        }
    }

    println(combinationsCount)
}

data class Line(
    val start: Int,
    val end: Int,
) {
    fun isOverlapped(other: Line): Boolean {
        return end >= other.start && start <= other.start
    }
}