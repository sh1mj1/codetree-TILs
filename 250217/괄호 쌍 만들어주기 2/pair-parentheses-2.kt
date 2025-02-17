
fun main() {
    val brackets = readln().trim()
    val bracketsLength = brackets.length

    (0 until bracketsLength - 3).sumOf { openIdx -> 
        if (brackets[openIdx] == '(' && brackets[openIdx + 1] == '(') {
            (openIdx + 2 until bracketsLength - 1).count { closeIdx ->
                brackets[closeIdx] == ')' && brackets[closeIdx + 1] == ')'
            }
        } else 0
    }.also {
        println(it)
    }
}

