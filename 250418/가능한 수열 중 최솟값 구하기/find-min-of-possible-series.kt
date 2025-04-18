fun main() {
    val totalLength = readLine()!!.toInt()
    val searchRange = 4..6

    fun isValid(numbers: List<Int>): Boolean {
        val size = numbers.size
        return (0 until size / 2).none { i ->
            val compared1 = numbers.subList(size - 1 - i, size)
            val compared2 = numbers.subList(size - 1 - (2 * i + 1) , size - i - 1)
            compared1 == compared2
        }
    }

    fun seq(numbers: List<Int>): List<Int> {
        if (numbers.size >= totalLength) return numbers

        return searchRange 
            .map { nextNumber -> numbers + nextNumber}
            .filter { nextNumbers -> isValid(nextNumbers) }
            .firstNotNullOfOrNull {curNumbers -> 
                seq(curNumbers)
                    .takeIf { result -> result.isNotEmpty() }
            }
            ?: emptyList()
    }

    seq(listOf(4)).joinToString("")
        .also(::println)
}