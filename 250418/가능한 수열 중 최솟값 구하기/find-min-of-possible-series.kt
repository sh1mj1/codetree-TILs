fun main() {
    val totalLength = readLine()!!.toInt()
    val searchRange = 4..6


    fun seq(numbers: List<Int>): List<Int> {
        val size = numbers.size

        if (size >= totalLength) {
            return numbers
        }

        outer@ for(nextNum in searchRange) {
            val nextNumbers = numbers + nextNum
            val nextSize = nextNumbers.size

            for (i in 0 until nextSize / 2) {
                val compared1 = nextNumbers.subList(nextSize - 1 - i, nextSize)
                val compared2 = nextNumbers.subList(nextSize - 1 - (2 * i + 1) , nextSize - i - 1)

                if (compared1 == compared2) {
                    continue@outer
                }
            }
            val result = seq(nextNumbers)
            if (result.isNotEmpty()) {
                return result
            }
        }
        return emptyList()
    }

    seq(listOf(4)).joinToString("")
        .also(::println)

}