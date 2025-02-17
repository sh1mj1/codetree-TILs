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

private fun adjacentNumber(number: Int, distance: Int): Int {
    return ((number + distance + n) % n).let {
        if (it == 0) n
        else it
    }
}

fun main() {
    val validPasswords = validPasswords(password1) union validPasswords(password2)
    println(validPasswords.size)
}



fun validPasswords(password: List<Int>): List<Triple<Int, Int, Int>> {
    return adjacents[password[0]].flatMap { i ->
        adjacents[password[1]].flatMap { j ->
            adjacents[password[2]].map { k ->
                Triple(i, j, k)
            }
        }
    }
}


/*

// 2️⃣ 가능한 조합을 함수형 API로 생성 (`O(1)`)
fun generateValidPasswords(password: List<Int>) =
    adjacents[password[0]].flatMap { i ->
        adjacents[password[1]].flatMap { j ->
            adjacents[password[2]].map { k ->
                Triple(i, j, k)
            }
        }
    }.toSet() // `Set`으로 변환하여 중복 제거

*/