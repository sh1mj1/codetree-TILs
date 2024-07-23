import java.util.*

val sc = Scanner(System.`in`)
val N = sc.nextInt()

fun recurse(n: Int) {
    if(n == 0) return

    print("$n ") 
    recurse(n-1) 
    print("$n ")
}


fun main() {
    recurse(N)
}