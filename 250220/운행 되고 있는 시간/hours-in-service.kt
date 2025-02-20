import kotlin.math.max

fun main() {
    val n = readln().toInt()

    val workers = List(n) {
        val (a, b) = readln().trim().split(" ").map(String::toInt)
        Worker(a, b)
    }

    workers.indices.maxOf { i ->
        workers
            .filterIndexed { index, _ -> index != i}
            .flatMap(Worker::workTimeRange)
            .toSet()
            .size
    }.let(::println)
}

data class Worker(
    val workStartTime: Int,
    val workEndTime: Int,
) {
    val workTimeRange: IntRange = workStartTime until workEndTime
}