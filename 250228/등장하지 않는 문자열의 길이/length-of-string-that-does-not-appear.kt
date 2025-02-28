fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    fun minUniqueSubstringLength(s: String): Int {
        for (length in 1..s.length) {
            val seen = mutableSetOf<String>()
            var isUnique = true

            for (i in 0..s.length - length) {
                val substring = s.substring(i, i + length)
                if (substring in seen) {
                    isUnique = false
                    break
                }
                seen.add(substring)
            }

            if (isUnique) return length
        }
        return s.length
    }

    println(minUniqueSubstringLength(s))
}
