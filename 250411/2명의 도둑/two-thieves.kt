import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val m = scanner.nextInt()
    val c = scanner.nextInt()

    val grid = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            grid[i][j] = scanner.nextInt()
        }
    }

    var answer = 0
    fun calculateMaxSum(index: Int): Int {
        val row = index / n
        val col = index % n
        val arr = IntArray(m) { grid[row][col + it] }

        var max = 0
        for (bit in 0 until (1 shl m)) {
            val subset = mutableListOf<Int>()
            for (i in 0 until m) { 
                if (bit and (1 shl i) != 0) {
                    subset.add(arr[i])
                }
            }
            var sum = 0
            var value = 0
            for (num in subset) {
                sum += num
                value += num * num
            }
            if (sum <= c) {
                max = max.coerceAtLeast(value)
            }
        }
        return max
    }

    fun combination(count: Int, start: Int, selected: IntArray) {
        if (count == 2) {
            val sum = calculateMaxSum(selected[0]) + calculateMaxSum(selected[1])
            answer = maxOf(answer, sum)
            return
        }

        for (i in start until n * n) {
            if (i % n + m > n) continue
            selected[count] = i
            combination(count + 1, i + m, selected)
        }
    }

    combination(0, 0, IntArray(2))
    println(answer)
}
