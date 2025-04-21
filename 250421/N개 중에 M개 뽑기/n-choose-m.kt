fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    // Please write your code here.

    fun printAllCombinations(count: Int, num: Int, curCombination: List<Int>) {
        if (count == m) {
            curCombination.joinToString(" ").also(::println)
            return
        }

        (num + 1 .. n).forEach { nextNum ->
            printAllCombinations(
                count = count + 1,
                num = nextNum,
                curCombination = curCombination + nextNum
            )
        }
    }

    printAllCombinations(
        count = 0,
        num = 0,
        curCombination = emptyList()
    )


}
