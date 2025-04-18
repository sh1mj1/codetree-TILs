fun main() {
    val totalLength = readLine()!!.toInt()
    // Please write your code here.
    val searchRange = 4 .. 6

    fun seq(length: Int, numbers: List<Int>): List<Int> {
        if (length > totalLength) {
            return numbers.subList(0, numbers.size - 1)
        }

        outer@ for (nextNumber in searchRange) {
            val nextNumbers = numbers + nextNumber
            val i = nextNumbers.size - 1

            if (nextNumbers.size > totalLength) {
                return numbers
            }

            for (k in 0 until (nextNumbers.size / 2)) {
                val compared1 = nextNumbers.subList(i - k, i + 1)
                val compared2 = nextNumbers.subList(i - (2 * k + 1), i - k)
                if (compared1 == compared2) {
                    continue@outer
                }
            }
            return seq(length + 1, nextNumbers)
        }
        return emptyList()
    }

    val answerList = seq(1, listOf(4))
    
    println(answerList.joinToString(""))
}