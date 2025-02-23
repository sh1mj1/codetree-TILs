
fun main() {
    val (studentsCount, budget) = readln().trim().split(" ").map(String::toInt)

    val prices = List(studentsCount) {
        readln().toInt()
    }
    
    val sortedPrices = prices.sortedBy { it }

    sortedPrices.forEach { price ->
        for (i in 1 until studentsCount) {
            val sum = (0 .. i).sumOf {
                if (it == i) 
                    sortedPrices[it] / 2
                else 
                    sortedPrices[it]
            }

            if (sum > budget) {
                println(i)
                return
            }
        }
    }

}