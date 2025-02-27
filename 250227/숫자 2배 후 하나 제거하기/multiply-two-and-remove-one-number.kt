import kotlin.math.abs
import kotlin.math.min

fun main() {
    val numberCount = readln().toInt()
    val numbers = readln().trim().split(" ").map(String::toInt).toIntArray()
    val idxRange = 0 until numberCount
    var minDiffSum = Int.MAX_VALUE

    for (i in idxRange) {
        numbers[i] *= 2

        for (j in idxRange) {
            var k = 0
            var diffSum = 0
            while (k < numberCount) { 
                if (k == j) {
                    k++
                    continue
                }

                if (k -1 < 0) {
                    k++
                    continue
                }

                if (k -1 == j) {
                    if (k - 2 < 0) {
                        k++
                        continue
                    }
                    val diff = abs(numbers[k] - numbers[k - 2])
                    diffSum += diff
                    k++
                    continue
                }

                val diff = abs(numbers[k] - numbers[k - 1])
                diffSum += diff
                k++
            }
            minDiffSum = min(minDiffSum, diffSum)
        }
        numbers[i] /= 2
    }

    println(minDiffSum)
}