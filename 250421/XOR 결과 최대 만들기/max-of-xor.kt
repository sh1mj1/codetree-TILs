import kotlin.math.max

fun main() {
    val (n, m) = readln().trim().split(" ").map { it.toInt() }
    val numbers = readln().trim().split(" ").map { it.toInt() }
    // Please write your code here.

    fun xorResult(combi: List<Int>): Int {
        return combi.reduce { acc, number -> 
            acc xor number
        }
    }

    fun answer(n: Int, m: Int): Int {
        var answer: Int = Int.MIN_VALUE
        fun find(numIdx: Int, remain: Int, curCombi: List<Int>) {
            if (remain == 0) {
                answer = max(answer, xorResult(curCombi))
                return
            }

            (numIdx until n).forEach {
                find(it + 1, remain - 1, curCombi + numbers[it])
            }
        }

        find(0, m, emptyList())
        return answer
    }

    println(answer(n, m))
}
