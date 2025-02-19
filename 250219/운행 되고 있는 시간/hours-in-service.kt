import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val workTimes = List(n) {
        val (a, b) = readln().trim().split(" ").map { it.toInt() }
        a to b
    }

    var maxRunningTime = 0

    for (i in 0 until n) { // i 번째 개발자를 해고
        val timeline = BooleanArray(1001)

        for (j in 0 until n) {
            if (j == i) continue // i 번째 개발자는 해고되었으므로 건너뛴다.

            val (start, end) = workTimes[j]
            for (t in start until end) {
                timeline[t] = true
            }
        }

        // 남아있는 개발자들의 총 운행 시간 계산
        val runningTime = timeline.count { it }

        maxRunningTime = max(maxRunningTime, runningTime)
    }

    println(maxRunningTime)
}