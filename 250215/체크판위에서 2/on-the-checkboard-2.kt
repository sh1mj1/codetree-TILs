

fun main() {
    val (rowCount, colCount) = readln().trim().split(" ").map(String::toInt)

    val grid = List(rowCount) {
        readln().trim().split(" ")
    }
    val firstColor = grid[0][0]
    val lastColor = grid[rowCount - 1][colCount - 1]

    var count = 0
    
    for (r1 in 1 .. rowCount - 3) {
        for (c1 in 1 .. colCount - 3) {
            val color1 = grid[r1][c1]

            if (color1.isDifferentWith(firstColor)) {
                for (r2 in r1 + 1 .. rowCount - 2) {
                    for (c2 in c1 + 1 .. colCount - 2) {
                        val color2 = grid[r2][c2]

                        if (color2.isDifferentWith(color1) && color2.isDifferentWith(lastColor)) {
                            count++
                        }
                    }
                }
            }
        }
    }
    println(count)
}

fun String.isDifferentWith(target: String): Boolean {
    if (this == "B") {
        return target == "W"
    }
    if (this == "W") {
        return target == "B"
    }
    return false
}