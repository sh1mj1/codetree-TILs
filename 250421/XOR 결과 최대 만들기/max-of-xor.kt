fun main() {
    val (n, m) = readln().trim().split(" ").map { it.toInt() }
    val numbers = readln().trim().split(" ").map { it.toInt() }
    // Please write your code here.

    fun combinations(n: Int, m: Int): List<List<Int>> {
        fun helper(idx: Int, remain: Int): List<List<Int>> {
            if (remain == 0) return listOf(emptyList())

            return (idx until n).flatMap { i ->
                helper(i + 1, remain - 1).map { it + numbers[i] }
            }
        }
        return helper(0, m)
    }

    val combinations = combinations(n, m)

    val answer = combinations.maxOf { combi ->
        combi.reduce { acc, number -> 
            acc xor number
        }
    }

    println(answer)
}
