

fun main() {
    val (n, t) = readln().trim().split(" ").map { it.toInt() }
    val (r, c, d) = readln().trim().split(" ")
    val range = 0 until n

    val point = Point(r.toInt() - 1, c.toInt() - 1, d)

    point.move(t, range)

    println(
        point.now()
    )
}

data class Point(
    private var row: Int,
    private var col: Int,
    private var cmd: String,
) {
    fun move(time: Int, range: IntRange) {
        if (time == 0) return 
        
        val nextRow = row + directions[cmd]!!.first
        val nextCol = col + directions[cmd]!!.second

        if(nextRow !in range || nextCol !in range) {
            switchDirection()
            move(time - 1, range)
        } else {
            row = nextRow
            col = nextCol
            move(time - 1, range)
        }
        
    }

    fun switchDirection() {
        when(cmd) {
            "U" -> cmd = "D"
            "D" -> cmd = "U"
            "R" -> cmd = "L"
            "L" -> cmd = "R"
            else -> error("invalid cmd")
        }
    }

    fun now(): String = "${row + 1} ${col + 1}"

    companion object {
        val directions = mapOf(
            "U" to (-1 to 0),
            "D" to (1 to 0),
            "R" to (0 to 1),
            "L" to (0 to -1),
        )
    }
}

