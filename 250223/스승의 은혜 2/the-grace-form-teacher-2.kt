fun main() {
    val (studentsCount, budget) = readln().trim().split(" ").map(String::toInt)
    val prices = List(studentsCount) { readln().toInt() }.sorted() // 가격을 오름차순 정렬

    val prefixSums = prices.runningFold(0) { acc, price -> acc + price }

    var maxStudents = 0

    for (discountIndex in 0 until studentsCount - 1) {
        val totalCost = prefixSums[discountIndex] + prices[discountIndex + 1] / 2

        if (totalCost <= budget) {
            maxStudents = discountIndex + 1
        } else {
            break
        }
    }

    println(maxStudents)
}