

fun main() {
    val input = readln().trim()
    val lastIdx = input.length - 1

    var count = 0
    (0 .. lastIdx).forEach { i ->
        if (input[i] == '(') {
            (i + 1 .. lastIdx).forEach { j ->
                if (input[j] == ')') {
                    count++
                }
            }
        }
    }

    println(count)

}