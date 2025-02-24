

fun main() {
    val (matchCount, devCount) = readln().trim().split(" ").map(String::toInt)
    val matchResults = List(matchCount) {
        readln().trim().split(" ").map(String::toInt)
    }

    var allDevPairCount = 0

    for (i in 1 .. devCount) {
        for (j in i + 1 .. devCount) {
            val (highPriority, lowPriority) = if (matchResults[0].indexOf(i) > matchResults[0].indexOf(j)) {
                Pair(j, i)
            } else {
                Pair(i, j)
            }
            
            if (
                matchResults.all { result ->
                    result.indexOf(highPriority) < result.indexOf(lowPriority)
                }
            ) {
                allDevPairCount++
            }    
        }
    }
    println(allDevPairCount)
}