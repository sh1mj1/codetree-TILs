fun main() {
    val ticTacToe: List<Number> = List(3) { row ->
        val line = readln().map { it.digitToInt() }
        listOf(
            Number(row, 0, line[0]),
            Number(row, 1, line[1]),
            Number(row, 2, line[2])
        )
    }.flatMap { it }

    val people = ticTacToe.map { it.value }.distinct().sorted()

    var count = 0

    for (i in people.indices) {
        for (j in i + 1 until people.count()) {
            val numbersForI = ticTacToe.filter { it.value == people[i] }
            val numbersForJ = ticTacToe.filter { it.value == people[j] }

            val numbers = numbersForI.union(numbersForJ).distinct()

            val numbersRow1 = numbers.filter { number -> number.row == 0 }
            if (numbersRow1.count() == 3 && numbersRow1.map { it.value }.toSet().count() == 2) {
                count++
                continue
            }

            val numbersRow2 = numbers.filter { number -> number.row == 1 }
            if (numbersRow2.count() == 3 && numbersRow2.map { it.value }.toSet().count() == 2) {
                count++
                continue
            }

            val numbersRow3 = numbers.filter { number -> number.row == 2 }
            if (numbersRow3.count() == 3 && numbersRow3.map { it.value }.toSet().count() == 2) {
                count++
                continue
            }

            val numbersCol1 = numbers.filter { number -> number.col == 0 }
            if (numbersCol1.count() == 3 && numbersCol1.map { it.value }.toSet().count() == 2) {
                count++
                continue
            }

            val numbersCol2 = numbers.filter { number -> number.col == 1 }
            if (numbersCol2.count() == 3 && numbersCol2.map { it.value }.toSet().count() == 2) {
                count++
                continue
            }
            
            val numbersCol3 = numbers.filter { number -> number.col == 2 }
            if (numbersCol3.count() == 3 && numbersCol3.map { it.value }.toSet().count() == 2) {
                count++
                continue
            }

            val numbersDiagonal1 = numbers.filter { number -> number.row == number.col }
            if (numbersDiagonal1.count() == 3 && numbersDiagonal1.map { it.value }.toSet().count() == 2) {
                count++
                continue
            }

            val numbersDiagonal2 = numbers.filter { number -> 
                (number.row == 0 && number.col == 2) ||
                (number.row == 1 && number.col == 1) ||
                (number.row == 2 && number.col == 0)
            }

            if (numbersDiagonal2.count() == 3 && numbersDiagonal2.map { it.value }.toSet().count() == 2) {
                count++
                continue
            }
        }
    }

    println(count)




}


data class Number(
    val row: Int,
    val col: Int,
    val value: Int,
)

/*

124
332
561

만약 1 3 이 팀 -> 우승
만약 2 3 이 팀 -> 우승

==> 팀전 승리 수: 2


    0  1  2

0           

1

2




*/


