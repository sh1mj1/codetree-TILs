fun main() {
    val (studentsCount, budget) = readln().trim().split(" ").map(String::toInt)
    val prices = List(studentsCount) { readln().toInt() }

    val sortedPrices = prices.sorted()

    val prefixSums = sortedPrices.runningFold(0) { acc, price -> acc + price }

    val maxStudents = (0 until studentsCount).maxOfOrNull { discountIndex ->
        (0..studentsCount).firstOrNull { i ->
            val totalCost = prefixSums[i] - sortedPrices.getOrNull(discountIndex)?.div(2) ?: 0
            totalCost > budget
        } ?: studentsCount
    } ?: studentsCount

    println(maxStudents)
}
