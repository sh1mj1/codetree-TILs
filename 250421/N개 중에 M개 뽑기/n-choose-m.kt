fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    // Please write your code here.

    fun combinations(n: Int, m: Int): List<List<Int>> {
        fun helper(start: Int, depth: Int): List<List<Int>> {
            if (depth == 0) return listOf(emptyList())

            return (start..n).flatMap { i ->
                helper(i + 1, depth - 1).map { listOf(i) + it }
            }
        }
    return helper(1, m)
    }

    combinations(n, m).forEach {
        println(it.joinToString(" "))
    }
}