val n = readln().toInt()
val A = readln().trim().split(" ").map{ it.toInt() }
val B = readln().trim().split(" ").map{ it.toInt() }

fun main() {
    val sortedA = A.sorted()
    val sortedB = B.sorted()

    if(sortedA.toString() == sortedB.toString()) {
        println("Yes")
        return
    }
    println("No")
}