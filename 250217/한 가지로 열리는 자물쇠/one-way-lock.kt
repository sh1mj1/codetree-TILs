import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val (x, y, z) = readln().trim().split(" ").map(String::toInt)

    val a = (1 .. n).count { abs(it - x) <= 2 }
    val b = (1 .. n).count { abs(it - y) <= 2 }
    val c = (1 .. n).count { abs(it - z) <= 2 }

    val allCombinationCount = n * n * n
    val wrongCombinationCount = (n - a) * (n - b) * (n - c)

    (allCombinationCount - wrongCombinationCount).let {
        println(it)
    }

}