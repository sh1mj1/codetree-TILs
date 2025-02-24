

fun main() {
    val (first, second) = readln().trim().split(" ").map(String::toInt)

    val max = (first .. second).maxOf { number ->
        number.toString().sumOf { digit ->
            digit.digitToInt()
        }
    }

    println(max)
}