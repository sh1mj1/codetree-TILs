fun main() {
    val numList = readln().trim().split(" ").map(String::toInt).sorted()

    fun isPossible(a: Int, b: Int, c: Int, d: Int): Boolean {
        val tempList = listOf(
            a, b, c, d,
            a + b, b + c, c + d, d + a, a + c, b + d,
            a + b + c, a + b + d, a + c + d, b + c + d,
            a + b + c + d
        ).sorted()

        return tempList == numList
    }

    for (i in 1..40) {
        for (j in i..40) {
            for (k in j..40) {
                for (h in k..40) {
                    if (isPossible(i, j, k, h)) {
                        println("$i $j $k $h")
                        return
                    }
                }
            }
        }
    }
}