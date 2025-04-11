import kotlin.math.max

fun main() {
    val (n, m, c) = readln().split(" ").map { it.toInt() }
    val weight = Array(n) { readln().trim().split(" ").map { it.toInt() } }
    // Please write your code here.
    var totalMaxPriceSum = 0

    fun thief2(
        startIdx: Int,
        currentCombination: List<Int>,
        cWeight: List<Int>,
        thief1Sum: Int,
    ) {
        for (idx in startIdx until n) {
            val cComb = currentCombination + cWeight[idx]

            val currentWeightSum =  cComb.sumOf { it }
            if (currentWeightSum > c) return

            val priceSum = cComb.sumOf { it * it }
            totalMaxPriceSum = max(totalMaxPriceSum, thief1Sum + priceSum)

            thief2(
                startIdx = idx + 1,
                currentCombination = cComb,
                cWeight = cWeight,
                thief1Sum = thief1Sum,
            )
        }
    }

    fun thief1(
        startIdx: Int,
        row: Int,
        currentCombination: List<Int>,
    ) {
        for (idx in startIdx until n) {
            var cComb = currentCombination + weight[row][idx]
            val currentWeightSum = cComb.sumOf { it }
            if (currentWeightSum > c) return

            val priceSum = cComb.sumOf { it * it }
            
            for (thief2Row in 0 until n) {
                if (thief2Row == row) {
                    for (startIdx in idx + 1 until n) {
                        thief2(
                            startIdx = startIdx,
                            currentCombination = emptyList(),
                            cWeight = weight[thief2Row],
                            thief1Sum = priceSum,
                        )
                    }
                } else {
                    for (startIdx in 0 until n) {
                        thief2(
                            startIdx = startIdx,
                            currentCombination = emptyList(),
                            cWeight = weight[thief2Row],
                            thief1Sum = priceSum,
                        )
                    }
                }
            }
            thief1(
                startIdx = idx + 1,
                row = row,
                currentCombination = cComb,
            )
        }
    }

    for (row in 0 until n) {
        for (sIdx in 0 until n) {
            thief1(
                startIdx = sIdx,
                row = row,
                currentCombination = emptyList(),
            )
        }
    }

    println(
        totalMaxPriceSum
    )
}