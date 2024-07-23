import java.util.*

val sc = Scanner(System.`in`)
val N = sc.nextInt()

fun recurse(i: Int) {
    if(i == 0) return
    
    repeat(i) {
        print("* ")
    }
    println()
    recurse(i-1)
    repeat(i) {
        print("* ")
    }
    println()
}

fun main() {
    recurse(N)
}