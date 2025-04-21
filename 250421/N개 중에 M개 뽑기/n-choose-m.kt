fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    // Please write your code here.

    fun allCombinations(n: Int, m: Int): List<List<Int>> {
        val allCombinations = mutableListOf<List<Int>>()

        fun combination(count: Int, num: Int, curCombi: List<Int>) {
            if (count == m) {
                allCombinations.add(curCombi)
            }

            (num + 1 .. n).forEach { 
                combination(count + 1, it, curCombi + it)
            }
        }
        
        combination(0, 0, emptyList())
        return allCombinations
    }


    allCombinations(n, m)
        .filter { it.isNotEmpty() }
        .forEach {
            println(it.joinToString(" "))
        }
    
}
