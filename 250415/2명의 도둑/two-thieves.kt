import kotlin.math.max

fun main() {
    val (n, m, c) = readln().split(" ").map { it.toInt() }
    val weight = Array(n) { readln().trim().split(" ").map { it.toInt() } }
    // Please write your code here.
    fun possible(r1: Int, c1: Int, r2: Int, c2: Int): Boolean {
        val lastC1 = c1 + m - 1
		if (lastC1 >= n) return false
        
        val lastC2 = c2 + m - 1
        if (lastC2 >= n) return false
        
        if (r1 == r2) {
            if (lastC1 >= c2 && c1 <= c2) return false
            if (c1 <= lastC2 && c1 >= c2) return false
        }
        
        return true
    }
    
    var curMax = 0
    var totalMax = 0
    
    fun findMax(depth: Int, curWeights: List<Int>, weights: List<Int>){
        // println(
        //     "depth: $depth curWeights: $curWeights weights: $weights"
        // )
        if (curWeights.sum() > c) return
        
        val priceSum = curWeights.sumOf { it * it }
        curMax = max(curMax, priceSum)
        
        for (idx in depth until m) {
            findMax(idx + 1, curWeights + weights[idx], weights)
        }
    }
    
    
    fun findMax(r: Int, c: Int): Int {
        val lastC = c + m - 1
        var max = 0
        val weights = weight[r].subList(c, c + m)
        
        findMax(0, emptyList(), weights)
        
        return curMax.also {curMax = 0}
    }
    
    for (r1 in 0 until n) {
        for (c1 in 0 until n) {
            for (r2 in 0 until n) {
                for (c2 in 0 until n) {
                    if (!possible(r1, c1, r2, c2)) continue
                    totalMax = max(totalMax, findMax(r1, c1) +  findMax(r2, c2))
                }
            }
        }
    }
    println(totalMax)
}