val firstWord = readln().trim().toCharArray()
val secondWord = readln().trim().toCharArray()

fun main() {
    if(firstWord.sortedArray().contentEquals(secondWord.sortedArray())) {
        println("Yes")
        return
    }
    println("No")
}