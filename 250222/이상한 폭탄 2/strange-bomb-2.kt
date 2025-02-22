fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val bombs = List(n) { readln().toInt() }

    val exploded = mutableSetOf<Int>()
    exploded.add(bombs[0]) // 첫 번째 폭탄은 무조건 폭발 시작

    for (i in 1 until n) {
        for (prev in exploded) {
            if (kotlin.math.abs(prev - bombs[i]) <= k) {
                exploded.add(bombs[i])
                break
            }
        }
    }

    println(exploded.maxOrNull() ?: -1)
}