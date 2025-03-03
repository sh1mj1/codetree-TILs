
// 시작 x 양의 정수
// 2 곱하기 N 번 반복

// 곱할 때마다 현재 숫자 범위에 대한 단서 a, b 가 주어짐.
// 2 배가 된 후의 값이 a 이상, b 이하임을 의미.


fun main() {
    val n = readln().toInt()
    val ranges = List(n) {
        readln().trim().split(" ").map(String::toInt)
            .let{ Range(it[0], it[1]) }
    }

    var satisfied = false

    for (i in 1 .. 5_000) {
        var num = i

        for (range in ranges) {
            num *= 2
            if (!range.contain(num)) break

            if (range == ranges.last()) {
                satisfied = true
            }
        }

        if (satisfied) {
            println(i)
            return
        }
    }
}

data class Range(
    private val start: Int,
    private val end: Int,
) {
    fun contain(target: Int): Boolean {
        return target >= start && target <= end
    }
}
