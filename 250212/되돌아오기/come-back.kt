

fun main() {
    val n = readln().toInt()
    val moves = List(n) {
        val (dir, count) = readln().split(" ")
        Move(dir, count.toInt())
    }
    val point = Point(0, 0)
    moves.forEach {
        point.moveUntilOrigin(it)
    }
}


data class Move(
    val dir: String,
    val count: Int,
)

data class Point(
    private var row: Int, 
    private var col: Int,
) {
    var time = 0
    fun moveUntilOrigin(move: Move) {
        when(move.dir) {
            "E" -> {
                for (count in move.count downTo 1) {
                    col++
                    time++
                    printIfOrigin()
                }
            }
            "S" ->  {
                for (count in move.count downTo 1) {
                    row++
                    time++
                    printIfOrigin()
                }
            }
            "W" -> {
                for (count in move.count downTo 1) {
                    col--
                    time++
                    printIfOrigin()
                }
            }
            "N" -> {
                for (count in move.count downTo 1) {
                    row--
                    time++
                    printIfOrigin()
                }
            }
            else -> error("invalid direction")
        }
    }

    fun printIfOrigin() {
        if (isOrigin()) {
            println(time)
            return
        }
    }

    fun isOrigin(): Boolean = row == 0 && col == 0
}
