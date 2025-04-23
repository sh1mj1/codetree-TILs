import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val nums = readLine()!!.trim().split(" ").map { it.toInt() }
    
    // Please write your code here.
    val allIndexes = (0 until 2 * n).toList()

    fun idxCombinations(x: Int, y: Int): List<Pair<List<Int>, List<Int>>> {
        val idxCombinations = mutableListOf<Pair<List<Int>, List<Int>>>()

        fun add(startIdx: Int, count: Int, idxes: List<Int>) {
            if (count >= n) {
                val selectedIdxes = idxes
                val other = allIndexes - selectedIdxes
                idxCombinations.add(
                    selectedIdxes to other
                )
                return 
            }

            for (idx in startIdx until 2 * n) {
                add(idx + 1, count + 1, idxes + idx)
            }   
        }

        add(1, 1, listOf(0))

        return idxCombinations
    }

    val idxCombinations = idxCombinations(2 * n, n)
        
    val answer = idxCombinations.minOf { combiPair ->
        val one = combiPair.first.map { nums[it] }
        val other = combiPair.second.map { nums[it] }

        abs(one.sum() - other.sum())
    }

    println(answer)

}