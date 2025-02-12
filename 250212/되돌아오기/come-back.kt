

fun main() {
    val n = readln().toInt()
    val moves = List(n) {
        val (dir, count) = readln().split(" ")
        Move(dir, count.toInt())
    }
    val point = Point(0, 0)
    moves.forEach {
        if (point.moveAndMeetOrigin(it)) {
            println(point.time)
            return
        }
    }
    println("-1")
    
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
    fun moveAndMeetOrigin(move: Move): Boolean {
        when(move.dir) {
            "E" -> {
                for (count in move.count downTo 1) {
                    col++
                    time++
                    if (isOrigin()) return true
                }
            }
            "S" ->  {
                for (count in move.count downTo 1) {
                    row++
                    time++
                    if (isOrigin()) return true
                }
            }
            "W" -> {
                for (count in move.count downTo 1) {
                    col--
                    time++
                    if (isOrigin()) return true
                }
            }
            "N" -> {
                for (count in move.count downTo 1) {
                    row--
                    time++
                    if (isOrigin()) return true
                }
            }
            else -> error("invalid direction")
        }
        return false
    }

    fun isOrigin(): Boolean = row == 0 && col == 0
}
