import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val nums = readln().trim().split(" ").map { it.toInt() }
    // Please write your code here.

    fun jumpCount(count: Int, pos: Int): Int {
        if (pos >= n) return Int.MAX_VALUE
        if (pos == n - 1)  {
            return count
        }

        return (1 .. nums[pos]).minOfOrNull { jump ->
            jumpCount(count + 1, pos + jump)
        } ?: Int.MAX_VALUE
    }

    println(
        jumpCount(0, 0)
            .takeIf{it != Int.MAX_VALUE} ?: -1
    )
}
