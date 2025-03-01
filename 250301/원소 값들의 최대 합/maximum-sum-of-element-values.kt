fun main() {
    val (n, m) = readlnOrNull()?.trim()?.split(" ")?.mapNotNull { it.toIntOrNull() } ?: return
    val sequence = readlnOrNull()?.trim()?.split(" ")?.mapNotNull { it.toIntOrNull() } ?: return

    var maxSum = 0

    for (startIndex in sequence.indices) {
        var currentIndex = startIndex
        var sum = 0

        repeat(m) {
            sum += sequence[currentIndex]
            currentIndex = sequence[currentIndex] - 1

            if (currentIndex !in sequence.indices) break // 인덱스 벗어나는 경우 방지
        }

        maxSum = maxOf(maxSum, sum)
    }

    println(maxSum)
}