fun main() {
    val (n, m) = readlnOrNull()?.trim()?.split(" ")?.mapNotNull { it.toIntOrNull() } ?: return
    val sequence = readlnOrNull()?.trim()?.split(" ")?.mapNotNull { it.toIntOrNull() } ?: return

    var maxSum = 0

    for (startIndex in sequence.indices) {
        var currentIndex = startIndex
        var sum = 0

        for (step in 0 until m) {
            if (currentIndex !in sequence.indices) break // 인덱스 벗어나는 경우 방지

            sum += sequence[currentIndex]
            currentIndex = sequence[currentIndex] - 1
        }

        maxSum = maxOf(maxSum, sum)
    }

    println(maxSum)
}