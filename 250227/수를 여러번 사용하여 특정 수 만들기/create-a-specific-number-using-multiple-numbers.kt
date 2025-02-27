fun main() {
    val (a, b, c) = readln().trim().split(" ").map(String::toInt)
    val (big, small) = if (a >= b) a to b else b to a
    

}
