fun main() {
    val input1 = readln().trim().split(" ").map { it.toInt() }
    val (n, t) = input1[0] to input1[1]

    val nums = readln().trim().split(" ").map {
        it.toInt()
    }

    var ans = 0
    var c = 0

    for (i in 0 until n) {
        if (nums[i] > t) {
            c++
            ans = maxOf(ans, c)
        } else {
            c = 0
        }
    }

    println(ans)
}