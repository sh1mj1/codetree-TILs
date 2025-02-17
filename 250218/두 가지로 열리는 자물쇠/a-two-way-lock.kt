val n = readln().toInt()
val password1 = readln().trim().split(" ").map(String::toInt)
val password2 = readln().trim().split(" ").map(String::toInt)

val adjacents = List(n + 1) { i ->
    setOf(
        ((i - 2 + n) % n).let { if (it == 0) n else it },  
        ((i - 1 + n) % n).let { if (it == 0) n else it },  
        i,  
        ((i + 1) % n).let { if (it == 0) n else it },  
        ((i + 2) % n).let { if (it == 0) n else it }
    )
}

val range = 1..n

fun main() {
    range.sumOf { i ->
        range.sumOf { j -> 
            range.count { k ->
                val target = Triple(i, j, k)
                valid(password1, target) || valid(password2, target)
            }
        }
    }.let(::println)
}

private fun valid(password: List<Int>, target: Triple<Int, Int, Int>): Boolean =
    target.first in adjacents[password[0]] &&
    target.second in adjacents[password[1]] && 
    target.third in adjacents[password[2]]