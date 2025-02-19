fun main() {
    val n = readln().toInt()
    val segments = List(n) {
        val (x1, x2) = readln().trim().split(" ").map { it.toInt() }
        x1 to x2
    }.sortedBy { it.first } // x1 기준으로 정렬

    var count = 0
    var maxX2 = Int.MIN_VALUE

    for ((x1, x2) in segments) {
        if (x1 > maxX2) { // 현재 선분이 기존 선분들과 겹치지 않는다면
            count++
        }
        maxX2 = maxOf(maxX2, x2) // 가장 멀리 뻗은 x2 업데이트
    }

    println(count)
}