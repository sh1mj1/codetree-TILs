import kotlin.math.max

fun main() {
    val (turnCount, boardSize, chipSize) = readln().trim().split(" ").map { it.toInt() }
    val moves = readln().trim().split(" ").map { it.toInt() }
    
    // Please write your code here.
    val positions = MutableList(chipSize) { 0 }
    var maxPoint = 0

    fun move(moveIdx: Int) {
        if (moveIdx >= turnCount) {
            val point = positions.count { it >= boardSize - 1 }
            maxPoint = max(maxPoint, point)
            return
        }

        for (chip in 0 until chipSize) {
            val currPosition = positions[chip]
            val nextPosition = if (positions[chip] + moves[moveIdx] >= boardSize) {
                boardSize - 1
            } else {
                positions[chip] + moves[moveIdx]
            }
            positions[chip] = nextPosition
            move(moveIdx + 1)
            positions[chip] = currPosition
        }
    }

    move(0)

    println(maxPoint)
}