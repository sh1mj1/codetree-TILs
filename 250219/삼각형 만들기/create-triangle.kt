import kotlin.math.abs
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val points = List(n) {
        val (x, y) = readln().trim().split(" ").map(String::toInt)
        x to y
    }

    var maxArea = 0

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            for (k in j + 1 until n) {
                val (x1, y1) = points[i]
                val (x2, y2) = points[j]
                val (x3, y3) = points[k]

                // x축과 평행한 변 찾기 (두 점의 y 좌표가 동일해야 함)
                val xParallel = if (y1 == y2) abs(x1 - x2)
                                else if (y1 == y3) abs(x1 - x3)
                                else if (y2 == y3) abs(x2 - x3)
                                else 0

                // y축과 평행한 변 찾기 (두 점의 x 좌표가 동일해야 함)
                val yParallel = if (x1 == x2) abs(y1 - y2)
                                else if (x1 == x3) abs(y1 - y3)
                                else if (x2 == x3) abs(y2 - y3)
                                else 0

                if (xParallel > 0 && yParallel > 0) {
                    maxArea = max(maxArea, xParallel * yParallel)
                }
            }
        }
    }

    println(maxArea)
}