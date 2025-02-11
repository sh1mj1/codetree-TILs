

fun main() {
    val n = readln().toInt()

    println(
        dfs(n)
    )
}

fun dfs(n: Int): Int {
    when (n) {
        1 -> return 1
        2 -> return 2
        else -> {
            return dfs(n / 3) + dfs(n - 1)
        }
    }
}

