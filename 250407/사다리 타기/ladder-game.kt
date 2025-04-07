fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val lines = mutableListOf<Pair<Int, Int>>()
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        lines.add(Pair(b, a - 1))
    }
    // Please write your code here.
    // line 은 0 부터 n-1 까지
    val horizontalLines = lines.map { line ->
        HorizontalLine(
            p1 = line.second,
            p2 = line.second + 1,
            height = line.first
        )
    }
    .sortedBy { it.height }

    val maxHeight = horizontalLines.maxOf { it.height }


    fun runStep(line: Int, height: Int): Int {
        if (height > maxHeight) return line

        val sameHeightLines = horizontalLines.filter { it.height == height }

        val meetingLine = sameHeightLines.find {
            it.p1 == line || it.p2 == line
        }

        if (meetingLine == null) return runStep(line, height + 1)

        if (meetingLine.p1 == line) return runStep(meetingLine.p1, height + 1)

        return runStep(meetingLine.p2, height + 1)
    }

    val results = (0 until n).map { line ->
        Result(
            start = line,
            dest = runStep(line, 1)
        )
    }
    .also(::println)
    

    


}



data class HorizontalLine(
    val p1: Int,
    val p2: Int,
    val height: Int,
)

data class Result(
    val start: Int,
    val dest: Int,
)


/*


*/