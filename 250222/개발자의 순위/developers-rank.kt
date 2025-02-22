fun main() {
    val (k, n) = readln().trim().split(" ").map(String::toInt)

    // K개의 경기별 순위 입력 받기
    val rankings = List(k) {
        readln().trim().split(" ").map { it.toInt() }
    }

    // (a, b) 쌍의 개수를 계산하기 위한 집합
    val consistentPairs = mutableSetOf<Pair<Int, Int>>()

    // 모든 개발자 번호 쌍을 확인
    for (a in 1..n) {
        for (b in 1..n) {
            if (a == b) continue

            // a가 모든 경기에서 b보다 높은 순위인지 확인
            val alwaysHigher = rankings.all { game ->
                game.indexOf(a) < game.indexOf(b)
            }

            if (alwaysHigher) {
                consistentPairs.add(Pair(a, b))
            }
        }
    }

    println(consistentPairs.size)
}