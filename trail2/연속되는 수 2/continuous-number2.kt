fun main() {
    val n = readln().toInt()
    val nums = IntArray(n) { 0 }
    for (i in 0 until n) {
        val num = readln().toInt()
        nums[i] = num
    }

    var ans = 0
    var seqC = 0
    for (i in 0 until n) {
        if (i == 0 || nums[i] == nums[i - 1]) {
            seqC++
            ans = maxOf(ans, seqC)
        } else {
            seqC = 1
        }
    }
    println(ans)
}
