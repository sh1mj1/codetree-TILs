import kotlin.math.max

fun main() {
    // n: 격자 크기     m: 연속 열 선택 개수    c: 최대 무게
    val (n, m, c) = readln().split(" ").map { it.toInt() }
    val weight = Array(n) { readln().split(" ").map { it.toInt() } }
    // Please write your code here.
    var maxTotalSum = 0

    val visited = List(n) { BooleanArray(n) { false } }

    fun isInRange(idx: Int): Boolean {
        return idx in 0 until n
    }

    fun t2Sum(row: Int): Int {
        val currentRow = weight[row]
        var s = 0
        var e = 0

        var maxPrice = 0

        while(s < n) {
            if (!isInRange(s)) break

            if (visited[row][s]) {
                s++
                e = s
                continue
            }
            
            val weightSum = (s .. e).sumOf { currentRow[it] }
            if (weightSum > c) {
                s++
                e = s
                continue
            }

            val priceSum = (s .. e).sumOf { currentRow[it] * currentRow[it] }
            maxPrice = max(priceSum, maxPrice)

            e++

            if (!isInRange(e) || visited[row][e]) {
                s++
                e = s
                continue
            }

        }
        return maxPrice
    }

    println(t2Sum(0))
    println(t2Sum(0))
    println(t2Sum(0))

}