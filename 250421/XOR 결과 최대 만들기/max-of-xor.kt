fun main() {
    val (n, m) = readln().trim().split(" ").map { it.toInt() }
    val numbers = readln().trim().split(" ").map { it.toInt() }
    // Please write your code here.

    fun combinations(n: Int, m: Int): List<List<Int>> {
        val combinations: MutableList<List<Int>> = mutableListOf()

        fun add(numIdx: Int, remain: Int, curCombi: List<Int>) {
            if (remain == 0) {
                combinations.add(curCombi)
                return
            }

            (numIdx until n).forEach {
                add(it + 1, remain - 1, curCombi + numbers[it])
            }
        }

        add(0, m, emptyList())
        return combinations
    }

    val combinations = combinations(n, m)

    val answer = combinations.maxOf { combi ->
        combi.reduce { acc, number -> 
            acc xor number
        }
    }

    println(answer)
}

// 1:30 ~