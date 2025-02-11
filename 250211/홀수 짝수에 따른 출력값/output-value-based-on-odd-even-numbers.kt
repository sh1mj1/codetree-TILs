

fun main() {
    val n = readln().toInt()

    println(
        dfs(n)
    )
}

fun dfs(n: Int): Int {
    if (n == 1) {
        return 1
    }
    if (n == 2) {
        return 1
    }
    
    return n + dfs(n - 2)
}