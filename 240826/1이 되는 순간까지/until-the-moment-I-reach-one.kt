import java.util.*

val sc = Scanner(System.`in`)

var count = 0

fun f(num: Int): Int {
    if(num == 1) {
        return count
    }
    count++

    if(num % 2 == 0) {
        return f(num / 2)
    }
    return f(num / 3)
}


fun main() {
    val N = sc.nextInt()
    
    println(f(N))
}