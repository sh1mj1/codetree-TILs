val dividers = List(9) { i ->
    10 - i
}


fun main() {
    val n = readln().toInt()
    val numbers = readln().trim().split(" ").map { it.toInt() }

    println(
        dfs(
            index = 0,
            acc = numbers[0],
            numbers = numbers, 
            size = numbers.size
        )
    )
}

fun dfs(index: Int, acc: Int, numbers: List<Int>, size: Int): Int {
    if (index == size - 1) return acc

    return dfs(
        index = index + 1,
        acc = lcm(acc, numbers[index + 1]),
        numbers = numbers,
        size = size
    )
}

fun lcm(a: Int, b: Int): Int {
    for (d in dividers) {
        if (a % d == 0 && b % d == 0) {
            return d * (a / d) * (b / d)
        }
    }
    return a * b
}