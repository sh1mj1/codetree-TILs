fun main() {
    val lineCount = readln().toInt()
    val lines = List(lineCount) {
        readln().trim().split(" ").map(String::toInt).let { Line(it[0], it[1]) }
    }

    var combinationsCount = 0

    for (i1 in 0 until lineCount - 2) {
        for (i2 in i1 + 1 until lineCount - 1) {
            for (i3 in i2 + 1 until lineCount) {
                val remainedLines = lines.filterIndexed { index, _ -> index != i1 && index != i2 && index != i3 }

                if (remainedLines.all { line1 ->
                        remainedLines.all { line2 ->
                            line1 == line2 || !line1.isOverlapped(line2)
                        }
                    }) {
                    combinationsCount++
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