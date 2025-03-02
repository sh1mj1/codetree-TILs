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

            // 가장 가까운 사람과의 거리 중 최대값을 찾는다
            if (minDistance > maxMinDistance) {
                maxMinDistance = minDistance
                bestSeat = i
            }
        }
    }

    seats[bestSeat] = '1'

    var finalMinDistance = n
    var prev = -1

    for (i in seats.indices) {
        if (seats[i] == '1') {
            if (prev != -1) {
                finalMinDistance = minOf(finalMinDistance, i - prev)
            }
            prev = i
        }
    }

    println(finalMinDistance)
}