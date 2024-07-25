// time: 1sec, mem: 80MB

import java.util.*

val sc = Scanner(System.`in`)

val K = sc.nextInt()
val N = sc.nextInt()

val list = mutableListOf<Int>()

fun printList(){
    list.forEach{ item ->
        print("$item ")
    }
    println()
}

fun recursive(curIdx: Int) {

    if(curIdx == N+1) {
        printList()
        return
    }

    for(i in 1..K) {
        list.add(i)
        recursive(curIdx+1)
        val count = list.size
        list.removeAt(count-1)
    }
}


fun main() {
    recursive(1)
}