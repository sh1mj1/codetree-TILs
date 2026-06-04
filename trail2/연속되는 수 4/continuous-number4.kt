fun main() {
    val n = readln().toInt()
    val nums = IntArray(n) { readln().toInt() }

    var c = 1
    var ans = 1

    for (i in 1 until n) {
        if (nums[i] > nums[i - 1]) {
            c++
            ans = maxOf(ans, c)
        } else {
            c = 1
        }
    }

    println(ans)
}
