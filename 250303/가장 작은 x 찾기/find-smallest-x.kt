fun main() {
    val n = readln().toInt()
    val ranges = List(n) { readln().split(" ").map { it.toInt() } }

    fun isReal(index: Int): Boolean {
        var now = index
        for (i in 0 until n) {
            now *= 2
            val (a, b) = ranges[i]
            if (now !in a..b) {
                return false
            }
        }
        return true
    }

    for (i in 1..(ranges[0][1] / 2)) {
        if (isReal(i)) {
            println(i)
            break
        }
    }
}