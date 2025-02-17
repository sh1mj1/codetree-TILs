import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val (x, y, z) = readln().trim().split(" ").map(String::toInt)

    val a = (1 until n).count {
        abs(it - x) <= 2
    }

    val b = (1 until n).count {
        abs(it - y) <= 2
    }

    val c = (1 until n).count {
        abs(it - z) <= 2
    }

    val allValidCount = n * n * (a + b + c)
    val onlyTwoValidCount = n * (a * b + a * c + b * c)
    val onlyOneValidCount = a * b * c

    (allValidCount - onlyTwoValidCount + onlyOneValidCount).let {
        println(it)
    }

}