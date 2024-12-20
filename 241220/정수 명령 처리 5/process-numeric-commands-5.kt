
fun main() {
    val commandsCount = readln().toInt()
    val arr = ArrayList<Int>()
    repeat(commandsCount) {
        val command = readln().split(" ")
        when(command[0]) {
            "push_back" -> arr.add(command[1].toInt())
            "pop_back" -> arr.remove(arr.size-1)
            "size" -> println(arr.size)
            "get" -> println(arr[command[1].toInt() - 1])
            else -> error("Illegal input")
        }
    }

}
