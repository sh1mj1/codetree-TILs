import kotlin.math.abs

fun main() {
    val (n, k) = readln().trim().split(" ").map(String::toInt)
    val numbers = List(n) { readln().toInt() }
    
    val sortedNumbers = numbers.sorted()

    val maxCount = sortedNumbers.withIndex().maxOf { (i, minNum) ->
        val maxNumIdx = sortedNumbers.indexOfLast { maxNum -> maxNum - minNum <= k }
            .takeIf { it >= 0 } ?: return@maxOf 0
        maxNumIdx - i + 1
    }

    println(maxCount)
}
