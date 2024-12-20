import java.util.*

fun main() {
    val commandsCount = readln().toInt()
    val list = LinkedList<Int>()
    repeat(commandsCount) {
        val command = readln().split(" ")
        when(command[0]) {
            "push_front" -> list.addFirst(command[1].toInt())
            "push_back" -> list.addLast(command[1].toInt())
            "pop_front" -> println(list.pollFirst())
            "pop_back" -> println(list.pollLast())
            "size" -> println(list.size)
            "empty" -> println(if(list.isEmpty()) 1 else 0 )
            "front" -> println(list.peekFirst())
            "back" -> println(list.peekLast())
            else -> error("Illegal Input")
        }
    }
}
