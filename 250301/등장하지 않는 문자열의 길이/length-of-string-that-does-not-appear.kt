fun main() {
    val n = readln().toInt()
    val inputString = readln()

    fun hasRepeatedSubstring(length: Int): Boolean {
        val seen = mutableSetOf<String>()
        for (i in 0..n - length) {
            val sub = inputString.substring(i, i + length)
            if (!seen.add(sub)) return true
        }
        return false
    }

    var left = 1
    var right = n
    var answer = n

    while (left <= right) {
        val mid = (left + right) / 2
        if (hasRepeatedSubstring(mid)) {
            left = mid + 1
        } else {
            answer = mid
            right = mid - 1
        }
    }

    println(answer)
}