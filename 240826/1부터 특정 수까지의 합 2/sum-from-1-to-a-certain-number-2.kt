import java.util.*

val sc = Scanner(System.`in`)

fun rec(num: Int): Int {
    if(num == 1) return 1

    return rec(num-1) + num
}

fun main() {
    val N = sc.nextInt()
    println(rec(N))
}