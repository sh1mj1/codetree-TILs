

fun main() {
    val (matchCount, devCount) = readln().trim().split(" ").map(String::toInt)
    val matchResults = List(matchCount) { readln().trim().split(" ").map(String::toInt) }


    val allDevPairCount = (1 .. devCount).sumOf { standardDev ->
        (standardDev + 1 .. devCount).count { targetDev -> 
            val (highPriority, lowPriority) = 
                if (matchResults.first().let { result -> result.indexOf(standardDev) > result.indexOf(targetDev) } ) 
                    targetDev to standardDev
                else
                    standardDev to targetDev
            
            matchResults.all { result -> result.indexOf(highPriority) < result.indexOf(lowPriority) }
        }
    }
    println(allDevPairCount)
}
