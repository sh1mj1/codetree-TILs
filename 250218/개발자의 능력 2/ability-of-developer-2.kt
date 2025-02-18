import kotlin.math.min

fun main() {
    val devs = readln().trim().split(" ").map(String::toInt)
    val totalSum = devs.sum()

    val range = 0 .. 5

    var minDiff = Int.MAX_VALUE

    range.forEach { i ->
        range.filter { it != i}.forEach { j ->
            val sum1 = devs[i] + devs[j]

            range.filter { it != i && it != j }.forEach { k ->
                range.filter { it != i && it != j && it != k }.forEach { l ->
                    val sum2 = devs[k] + devs[l]
                    val sum3 = totalSum - sum1 - sum2

                    val sums = listOf(sum1, sum2, sum3)
                    minDiff = min(minDiff, sums.maxOf{it} - sums.minOf{it})
                }
            } 
        } 
    }
    println(minDiff)
}
