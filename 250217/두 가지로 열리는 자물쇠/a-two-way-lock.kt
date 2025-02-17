val n = readln().toInt()

fun main() {
    val password1 = readln().trim().split(" ").map(String::toInt)
    val password2 = readln().trim().split(" ").map(String::toInt)

    var count = 0

    for (i in 1 .. n) {
        for (j in 1 .. n) {
            for (k in 1 .. n) {
                if (
                    (password1[0].isAdjacent(i) && password1[1].isAdjacent(j) && password1[2].isAdjacent(k)) || 
                    (password2[0].isAdjacent(i) && password2[1].isAdjacent(j) && password2[2].isAdjacent(k))
                ) {
                    count++
                }   
            }
        }
    }
    println(count)
}

private fun Int.isAdjacent(target: Int): Boolean {
    val diff = kotlin.math.abs(this - target)
    return diff <= 2 || diff >= n - 2
}