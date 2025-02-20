import kotlin.math.min
import kotlin.math.max

fun main() {
    val n = readln().toInt()

    var startOperatingTime = 0
    var endOperatingTime = 1_000

    val workers = List(n) {
        val (x, y) = readln().trim().split(" ").map(String::toInt)
        startOperatingTime = min(x, startOperatingTime)
        endOperatingTime = max(y, startOperatingTime)
        Worker(x, y)
    }

    var maxOperatingTime = 0
    var workTimes = MutableList(1_001) { 0 }

    for (i in 0 until n) {
        var currentOperatingTime = 0
        for (j in 0 until n) {
            if (i != j) {
                with(workers[j]) {
                    workTimeRange.forEach {
                        if (workTimes[it] == 0) currentOperatingTime++
                        workTimes[it]++
                    }
                }
            }
        }
        workTimes = MutableList(1_001) { 0 }
        maxOperatingTime = max(maxOperatingTime, currentOperatingTime)        
    }

    println(maxOperatingTime)
}

data class Worker(
    val workStartTime: Int,
    val workEndTime: Int,
) {
    val workTimeRange = (workStartTime until workEndTime)
}
