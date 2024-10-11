val N = readln().toInt()
val numbers = readln().trim().split(" ").map { it.toInt() }

fun main() {
    val sortedNumbers = numbers.sorted().toMutableList()
    var max = 0

    repeat(N) {
        val first = sortedNumbers.removeAt(0)
        val last = sortedNumbers.removeAt(sortedNumbers.size-1)
        max = kotlin.math.max(max, first + last)
    }
    println(max)
}