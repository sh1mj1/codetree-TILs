import java.util.*

val sc = Scanner(System.`in`)
val n = sc.nextInt()

fun rF(i: Int) {
    if(i == n + 1) return
    repeat(i) {
        print("*")
    }
    println()
    rF(i+1)
}

fun main() {
    rF(1)
}