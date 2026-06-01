fun main() {
    val n = readln().toInt()

    val nums = readln().trim().split(" ").map { it.toInt() }

    var m = 0

    for (i in 0 .. n-3) {
        for (j in i + 2 .. n-1) {
            m = maxOf(m, nums[i] + nums[j])
        }
    }
    println(m)
}