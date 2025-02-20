import kotlin.math.max

fun main() {
    val n = readln().toInt()

    val workers = List(n) {
        val (a, b) = readln().trim().split(" ").map(String::toInt)
        Worker(a, b)
    }

    val maxOperatingTime = workers.indices.maxOf { i ->
        workers
            .filterIndexed { index, _ -> index != i }
            .flatMap { it.workTimeRange }
            .toSet()
            .size
    }

    println(maxOperatingTime)
}

data class Worker(
    val workStartTime: Int,
    val workEndTime: Int,
) {
    val workTimeRange: Set<Int> = (workStartTime until workEndTime).toSet()
}