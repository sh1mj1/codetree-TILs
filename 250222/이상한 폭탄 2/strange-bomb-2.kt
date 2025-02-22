fun main() {
    val (n, k) = readln().trim().split(" ").map(String::toInt)
    val bombs = List(n) { readln().toInt() }

    // 폭발할 폭탄 번호 저장
    val exploded = mutableSetOf<Int>()

    // 순서대로 폭발하는지 확인
    for (i in bombs.indices) {
        val current = bombs[i]

        // 현재 폭탄이 폭발하는지 확인
        if (exploded.any { existing -> kotlin.math.abs(existing - current) <= k }) {
            exploded.add(current)
        }
    }

    // 폭발한 폭탄 중 가장 큰 번호 찾기
    println(exploded.maxOrNull() ?: -1)
}