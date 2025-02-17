val n = readln().toInt()
val password1 = readln().trim().split(" ").map(String::toInt)
val password2 = readln().trim().split(" ").map(String::toInt)

fun adjacentNumbers(x: Int) = setOf(
    (x - 2 + n) % n.let { if (it == 0) n else it },
    (x - 1 + n) % n.let { if (it == 0) n else it },
    x,
    (x + 1) % n.let { if (it == 0) n else it },
    (x + 2) % n.let { if (it == 0) n else it }
)

fun main() {
    val validPasswords = mutableSetOf<Triple<Int, Int, Int>>()

    for (i in adjacentNumbers(password1[0])) {
        for (j in adjacentNumbers(password1[1])) {
            for (k in adjacentNumbers(password1[2])) {
                validPasswords.add(Triple(i, j, k))
            }
        }
    }

    for (i in adjacentNumbers(password2[0])) {
        for (j in adjacentNumbers(password2[1])) {
            for (k in adjacentNumbers(password2[2])) {
                validPasswords.add(Triple(i, j, k))
            }
        }
    }

    println(validPasswords.size)
}
