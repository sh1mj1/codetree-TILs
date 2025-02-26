import kotlin.math.abs
import kotlin.math.min

fun main() {
    // 입력 처리
    val n = readln().toInt()
    val numList = readln().trim().split(" ").map { it.toInt() }

    // calc_2(doubledNums, k) 함수
    fun calc_2(doubledNums: List<Int>, k: Int): Int {
        val tempNums = doubledNums.filterIndexed { index, _ -> index != k }
        return (0 until tempNums.size - 1).sumOf { abs(tempNums[it] - tempNums[it + 1]) }
    }

    // calc(k) 함수
    fun calc(k: Int): Int {
        val tempNums = numList.toMutableList()
        tempNums[k] *= 2

        return (0 until n).minOf { calc_2(tempNums, it) }
    }

    // minDiff 초기값 설정
    var minDiff = Int.MAX_VALUE

    // 두배 해줄 인덱스 완전탐색
    for (i in 0 until n) {
        minDiff = min(minDiff, calc(i))
    }

    // 결과 출력
    println(minDiff)
}