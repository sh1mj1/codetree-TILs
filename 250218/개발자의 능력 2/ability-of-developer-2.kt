
fun main() {
    val devs = readln().trim().split(" ").map(String::toInt)
    val totalSum = devs.sum()

    val range = 0 .. 5

    range.flatMap { i ->
        range.filter { it != i}.flatMap { j ->
            val sum1 = devs[i] + devs[j]
            
            range.filter { it != i && it != j }.flatMap { k ->
                range.filter { it != i && it != j && it != k }.map { l ->
                    val sum2 = devs[k] + devs[l]
                    val sum3 = totalSum - sum1 - sum2
                    val sums = listOf(sum1, sum2, sum3)
                    
                    sums.maxOf { it } - sums.minOf { it }
                }
            } 
        } 
    }.minOf{it}.let(::println)
}
