import kotlin.math.max

fun main() {
    val (turnCount, boardSize, chipSize) = readln().split(" ").map { it.toInt() }
    val moves = readln().split(" ").map { it.toInt() }
    
    // Please write your code here.
    var maxPoint = 0

    fun move(
        moveIdx: Int,
        positions: List<Int>,
    ) {
        if (moveIdx >= turnCount) {
            val point = positions.count { it >= boardSize - 1 }
            maxPoint = max(maxPoint, point)
            return
        }

        for (chip in 0 until chipSize - 1) {
            val currPositions = positions.toMutableList()
            var nextPosition = positions[chip] + moves[moveIdx]
            if (nextPosition >= boardSize) {
                nextPosition = boardSize - 1
            }
            currPositions[chip] = nextPosition
            move(moveIdx + 1, currPositions)
        }
    }

    move(0, List(chipSize) { 0 })

    println(maxPoint)
}