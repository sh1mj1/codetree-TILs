fun main() {
    val (n, b) = readln().trim().split(" ").map(String::toInt)
    val prices = List(n) { readln().trim().toInt() }

    // 가격을 오름차순 정렬
    val sortedPrices = prices.sorted()
    var maxStudents = 0
    var budget = b

    // 할인 적용 가능한 경우를 고려
    for (i in sortedPrices.indices) {
        var tempBudget = budget
        var tempStudents = 0
        val discountedPrices = sortedPrices.toMutableList()
        discountedPrices[i] /= 2 // 한 상품만 할인 적용

        for (price in discountedPrices) {
            if (tempBudget >= price) {
                tempBudget -= price
                tempStudents++
            } else {
                break
            }
        }
        maxStudents = maxOf(maxStudents, tempStudents)
    }

    println(maxStudents)
}