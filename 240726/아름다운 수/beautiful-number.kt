import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()

var ans = 0

val list = mutableListOf<Int>()

fun main() {
    for(i in 1 .. 4){
        list.add(i)
        select(1)
        list.removeAt(list.size - 1)
    }
    println(ans)
}   


fun select(depth: Int) {
    if(depth == n){
        if(isBeautiful()) {
            ans++
        }
        return
    }

    for(i in 1..4){
        list.add(i)
        select(depth+1)
        list.removeAt(list.size - 1)
    }
}

fun isBeautiful(): Boolean {
    var i = 0
    while(i < list.size) {
        val count = list[i]
        for(j in 0 until count) {
            if(i >= list.size) return false
            if(list[i] != count) return false
            i++
        }
    }
    return true
}