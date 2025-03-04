import kotlin.math.abs

fun main() {
    val (n, k) = readln().trim().split(" ").map(String::toInt)
    val numbers = List(n) { readln().toInt() }
    
    val sortedNumbers = numbers.sorted()

    val maxCount = sortedNumbers.withIndex().maxOf { (i, minNum) ->
        (n - 1 downTo i).maxOf { j ->
            val maxNum = sortedNumbers[j]
            if (maxNum - minNum <= k) {
                j - i + 1 // count
            } else {
                0
            }
        }
    }

    println(maxCount)
}
