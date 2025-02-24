

fun main() {
    val lineCount = readln().toInt()
    val baseLine = List(101) { mutableListOf<Line>() }

    val lines = List(lineCount) {
        readln().trim().split(" ").map(String::toInt).let { Line(it[0], it[1]) }
    }
    var combinationCount = 0

    lines.forEach { line ->
        (line.start .. line.end).forEach {
            baseLine[it].add(line)
        }
    }

    for (i1 in 0 until lineCount - 2) {
        for (i2 in i1 + 1 until lineCount - 1) {
            for (i3 in i2 + 1 until lineCount) {
                val line1 = lines[i1]
                val line2 = lines[i2]
                val line3 = lines[i3]

            val copiedBaseLine = baseLine.map { it.toMutableList() }

                (line1.start..line1.end).forEach { copiedBaseLine[it].remove(line1) }
                (line2.start..line2.end).forEach { copiedBaseLine[it].remove(line2) }
                (line3.start..line3.end).forEach { copiedBaseLine[it].remove(line3) }

                
                if (copiedBaseLine.all { it.size == 1 || it.isEmpty() }) combinationCount++
            }
        }
    }

    println(combinationCount)
}

data class Line(
    val start: Int,
    val end: Int,
)
