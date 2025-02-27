fun main() {
    val (a, b, c) = readln().trim().split(" ").map(String::toInt)
    val (big, small) = if (a >= b) a to b else b to a

    val sums = mutableSetOf<Int>()

    var addBigCount = 0
    var sum = 0
    
    while (sum <= c) {
        addBigCount++
        sum += big
    }
    if (sum > c) {
        sum -= big
        addBigCount--
    }

    sums.add(sum)

    while (addBigCount > 0) {
        sum -= big
        addBigCount--
        
        var addSmallCount = 0
        while (sum <= c) {
            sum += small
            addSmallCount++
        }
        if (sum > c) {
            sum -= small
            addSmallCount--
        }
        
        sums.add(sum)

        repeat(addSmallCount) {
            sum -= small
        }
    }

    println(sums.maxOf { it })
}
