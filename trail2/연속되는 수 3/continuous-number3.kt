fun main() {
    val n = readln().toInt()
    val nums = IntArray(n) { readln().toInt() }
    
    // Please write your code here.
    var ans = 0
    var cnt = 0

    for (i in 0 until n) {
        if (i == 0 || nums[i] * nums[i - 1] > 0) {
            cnt++
            ans = maxOf(ans, cnt)
        } else {
            cnt = 1
        }
    }

    println(ans)
}
