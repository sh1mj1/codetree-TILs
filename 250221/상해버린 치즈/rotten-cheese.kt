fun main() {
    val (n, m, d, s) = readln().trim().split(" ").map(String::toInt)

    // 치즈 섭취 기록 저장: 치즈 번호 -> (사람, 시간) 리스트
    val cheeseRecords = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    repeat(d) {
        val (p, c, t) = readln().trim().split(" ").map(String::toInt)
        cheeseRecords.getOrPut(c) { mutableListOf() }.add(p to t)
    }

    // 아픈 사람 기록 저장: 사람 -> 아픈 시간
    val sickRecords = mutableMapOf<Int, Int>()
    repeat(s) {
        val (p, t) = readln().trim().split(" ").map(String::toInt)
        sickRecords[p] = t
    }

    var maxAffected = 0

    // 치즈 종류 1 ~ M 중에서 하나를 상한 치즈로 가정하고 검증
    for (cheese in 1..m) {
        if (cheese !in cheeseRecords) continue  // 해당 치즈를 먹은 사람이 없으면 무시

        val eatenBy = cheeseRecords[cheese] ?: continue
        val affectedPeople = mutableSetOf<Int>()

        // 상한 치즈를 먹은 사람이 아픈지 확인
        for ((person, eatTime) in eatenBy) {
            val sickTime = sickRecords[person] ?: Int.MAX_VALUE // 만약 아프지 않았다면 큰 값으로 처리
            if (sickTime > eatTime) {
                affectedPeople.add(person)
            }
        }

        // 모든 아픈 사람이 이 치즈를 먹었어야 함
        if (sickRecords.keys.all { it in affectedPeople }) {
            maxAffected = maxOf(maxAffected, eatenBy.map { it.first }.toSet().size)
        }
    }

    println(maxAffected)
}