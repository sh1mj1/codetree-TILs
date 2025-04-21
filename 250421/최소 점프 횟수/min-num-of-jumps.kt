import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val nums = readln().split(" ").map { it.toInt() }
    // Please write your code here.
    var minJumpCount = Int.MAX_VALUE

    fun jumpCount(count: Int, position: Int) {
        if (position >= n) return
        if (position == n - 1) {
            minJumpCount = min(minJumpCount, count)
        }

        for (i in 1 .. nums[position]) {
            jumpCount(count + 1, position + i)
        }
    }

    jumpCount(0, 0)
    minJumpCount = if (minJumpCount == Int.MAX_VALUE) {
        -1
    } else {
        minJumpCount
    }

    println(minJumpCount)
}