fun main() {
    val (matchCount, devCount) = readln().trim().split(" ").map(String::toInt)
    val matchResults = List(matchCount) { readln().trim().split(" ").map(String::toInt) }

    val firstMatchOrder = matchResults.first()

    var totalImmutablePairs = 0

    for (standardDev in 1 until devCount) {
        for (targetDev in standardDev + 1 .. devCount) {
            val highPriority: Int
            val lowPriority: Int

            if (isHighPriority(standardDev, targetDev, firstMatchOrder)) {
                highPriority = standardDev
                lowPriority = targetDev
            } else {
                highPriority = targetDev
                lowPriority = standardDev
            }

            var isImmutable = true
            for (match in matchResults) {
                if (!isHighPriority(highPriority, lowPriority, match)) {
                    isImmutable = false
                    break
                }
            }

            if (isImmutable) totalImmutablePairs++
        }
    }

    println(totalImmutablePairs)
}

fun isHighPriority(high: Int, low: Int, source: List<Int>): Boolean {
    var highAppear = false
    var lowAppear = false

    source.forEach {
        if (it == high) highAppear = true
        if (it == low) lowAppear = true

        if (lowAppear && !highAppear) return false
        if (highAppear && !lowAppear) return true
    }

    return false
}



