fun main() {
    val n = readln().toInt()
    val segments = List(n) {
        readln().split(" ").map { it.toInt() }.let { it[0] to it[1] }
    }.sortedBy { it.first } // 시작점을 기준으로 정렬

    var validCases = 0

    // 모든 3개의 선분을 제거하는 조합을 확인
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            for (k in j + 1 until n) {
                // 제거되지 않은 선분들
                val remaining = segments.filterIndexed { index, _ -> index != i && index != j && index != k }

                if (!isOverlapping(remaining)) {
                    validCases++
                }
            }
        }
    }

    println(validCases)
}

// 남은 선분들이 겹치는지 검사하는 함수
fun isOverlapping(segments: List<Pair<Int, Int>>): Boolean {
    for (i in 0 until segments.size - 1) {
        if (segments[i].second >= segments[i + 1].first) {
            return true // 겹치는 경우
        }
    }
    return false // 겹치지 않는 경우
}