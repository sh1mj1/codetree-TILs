fun main() {
    val n = readln().toInt()
    val seats = readln()

    val occupiedIndices = seats.indices.filter { seats[it] == '1' }

    if (occupiedIndices.isEmpty()) {
        println(n - 1)
        return
    }

    var maxMinDistance = 0

    for (i in seats.indices) {
        if (seats[i] == '0') {
            val minDistance = occupiedIndices.minOf { kotlin.math.abs(it - i) }
            maxMinDistance = maxOf(maxMinDistance, minDistance)
        }
    }

    println(maxMinDistance)
}