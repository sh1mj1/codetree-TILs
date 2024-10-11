fun main() {
    readln().trim()
        .toCharArray()
        .sortedArray()
        .forEach {
            print("$it")
        }
}