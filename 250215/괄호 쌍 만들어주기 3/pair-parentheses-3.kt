

fun main() {
    val input = readln().trim()
    val lastIdx = input.length - 1

    val count = input.withIndex().sumOf { (i, b1) -> 
        if ( b1 == '(') {
            (i + 1 .. lastIdx).count { j ->
                input[j] == ')'
            }
        } else 0
    }

    println(count)

}
