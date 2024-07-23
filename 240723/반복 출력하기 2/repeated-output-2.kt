import java.util.*

val sc = Scanner(System.`in`)
val N = sc.nextInt()

fun recursivePrint(n: Int) {
    if(n == 0){
        return
    }
    println("HelloWorld")
    recursivePrint(n -1)
}

fun main() {
    recursivePrint(N)
}