

fun main() {
    val (rowCount, colCount) = readln().trim().split(" ").map(String::toInt)

    val grid = List(rowCount) {
        readln().trim().split(" ")
    }
    val firstColor = grid[0][0]
    val lastColor = grid[rowCount - 1][colCount - 1]

    val count = 
    (1 until rowCount - 2).sumOf { r1 ->
        (1 until colCount - 2).sumOf { c1 -> 
            val color1 = grid[r1][c1]
            if (color1.isSameWith(firstColor)) return@sumOf 0

            (r1 + 1 until rowCount - 1).sumOf { r2 ->
                (c1 + 1 until colCount - 1).count { c2 ->
                    val color2 = grid[r2][c2]
                    color2.isDifferentWith(color1) && color2.isDifferentWith(lastColor)
                }
            }
        }
    }

    println(count)
}

fun String.isSameWith(target: String): Boolean = this == target

fun String.isDifferentWith(target: String): Boolean = this != target
