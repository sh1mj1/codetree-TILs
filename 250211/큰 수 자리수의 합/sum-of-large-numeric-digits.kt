

fun main() {
    val nums = readln().trim().split(" ").map { it.toInt() }
    val totalProduct = nums.reduce { acc, value ->
        acc * value
    }
    println(
        dfs(totalProduct)
    )
}

fun dfs(n: Int): Int {
    if (n < 10) return n
    
    val remainder = n % 10
    return remainder + dfs(n / 10)
}

