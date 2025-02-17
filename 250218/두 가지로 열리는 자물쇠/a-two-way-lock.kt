val n = readln().toInt()
val password1 = readln().trim().split(" ").map(String::toInt)
val password2 = readln().trim().split(" ").map(String::toInt)

val adjacents = List(n + 1) { i ->
    setOf(
        adjacentNumber(i, -2),
        adjacentNumber(i, -1),
        i,
        adjacentNumber(i, 1),
        adjacentNumber(i, 2),
    )
}

val range = 1..n
val numbersSet = (1..n).map{ it }.toSet()

fun main() {
    val validPasswords = generateValidPasswords(password1) union generateValidPasswords(password2)
    println(validPasswords.size)
}

private fun adjacentNumber(number: Int, distance: Int): Int {
    return ((number + distance + n) % n).let {
        if (it == 0) n
        else it
    }
}

fun generateValidPasswords(password: List<Int>): Set<Triple<Int, Int, Int>> {
    val validPasswords = mutableSetOf<Triple<Int, Int, Int>>()
    for (i in adjacents[password[0]]) {
        for (j in adjacents[password[1]]) {
            for (k in adjacents[password[2]]) {
                validPasswords.add(Triple(i, j, k))
            }
        }
    }
    return validPasswords
}
