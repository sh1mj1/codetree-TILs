fun main() {
    val n = readln().toInt()
    val seats = readln().toCharArray()

    val occupiedIndices = seats.indices.filter { seats[it] == '1' }

    if (occupiedIndices.isEmpty()) {
        println(n - 1)
        return
    }

    var maxMinDistance = 0

    var bestSeat = -1

    for (i in seats.indices) {
        if (seats[i] == '0') {
            val minDistance = occupiedIndices.minOf { kotlin.math.abs(it - i) }

            if (minDistance > maxMinDistance) {
                maxMinDistance = minDistance
                bestSeat = i
            }
        }
    }

    println(maxMinDistance)
}
