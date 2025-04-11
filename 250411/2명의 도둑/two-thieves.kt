import java.util.*

const val MAX_M = 5
const val MAX_N = 10

var n = 0
var m = 0
var c = 0

val weight = Array(MAX_N) { IntArray(MAX_N) }
val a = IntArray(MAX_M)

var ans = 0
var maxVal = 0

fun findMaxSum(currIdx: Int, currWeight: Int, currVal: Int) {
    if (currIdx == m) {
        if (currWeight <= c) {
            maxVal = maxOf(maxVal, currVal)
        }
        return
    }

    // 현재 인덱스를 선택하지 않는 경우
    findMaxSum(currIdx + 1, currWeight, currVal)

    // 현재 인덱스를 선택하는 경우
    val w = a[currIdx]
    findMaxSum(currIdx + 1, currWeight + w, currVal + w * w)
}

fun findMax(sx: Int, sy: Int): Int {
    for (i in 0 until m) {
        a[i] = weight[sx][sy + i]
    }

    maxVal = 0
    findMaxSum(0, 0, 0)
    return maxVal
}

fun intersect(a: Int, b: Int, c: Int, d: Int): Boolean {
    return !(b < c || d < a)
}

fun possible(sx1: Int, sy1: Int, sx2: Int, sy2: Int): Boolean {
    if (sy1 + m - 1 >= n || sy2 + m - 1 >= n) return false
    if (sx1 != sx2) return true
    if (intersect(sy1, sy1 + m - 1, sy2, sy2 + m - 1)) return false
    return true
}

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()
    c = sc.nextInt()

    for (i in 0 until n) {
        for (j in 0 until n) {
            weight[i][j] = sc.nextInt()
        }
    }

    for (sx1 in 0 until n) {
        for (sy1 in 0 until n) {
            for (sx2 in 0 until n) {
                for (sy2 in 0 until n) {
                    if (possible(sx1, sy1, sx2, sy2)) {
                        val value = findMax(sx1, sy1) + findMax(sx2, sy2)
                        ans = maxOf(ans, value)
                    }
                }
            }
        }
    }

    println(ans)
}