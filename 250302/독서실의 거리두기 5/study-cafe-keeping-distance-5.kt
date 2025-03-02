import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val seats = readln().trim()

    val occupiedIndicesFirst = seats.indices.filter { seats[it] == '1' }
    val vacantIndicesFirst = seats.indices.filter { seats[it] == '0' }

    val bestSeat = vacantIndicesFirst
        .maxByOrNull { i -> occupiedIndicesFirst.minOf { abs(it - i) } }
        ?: return

    val updatedSeats = seats.mapIndexed { index, char ->
        if (index == bestSeat) '1' else char
    }

    val finalMinDistance = updatedSeats
        .mapIndexedNotNull { index, c -> if (c == '1') index else null }
        .zipWithNext { a, b -> b - a }
        .minOrNull() ?: n

    println(finalMinDistance)
}