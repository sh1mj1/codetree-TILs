import kotlin.math.abs

fun main() {
    val (n, k) = readln().trim().split(" ").map(String::toInt)
    val numbers = List(n) { readln().toInt() }
    
    val ascendingNumbers = numbers.sorted()
    val descendingNumbers = numbers.sortedDescending()

    for (i in n downTo 0) {
        val ascending = ascendingNumbers.subList(0, i)
        
        val ascendingMax = ascending.maxOf { it }
        val ascendingMin = ascending.minOf { it }
        if (abs(ascendingMax - ascendingMin) <= k) {
            println(i)
            return
        }

        val descending = descendingNumbers.subList(0, i)

        val descendingMax = descending.maxOf { it }
        val descendingMin = descending.minOf { it }

        if (abs(descendingMax - descendingMin) <= k) {
            println(i)
            return
        }
    }
}