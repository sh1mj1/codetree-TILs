import java.util.*

val sc = Scanner(System.`in`)

// finbonacci
// f(x) = f(x-2) + f(x-1)

fun fibo(num: Int): Int = 
    when(num) {
        1 -> 1
        2 -> 1
        else -> fibo(num - 1) + fibo(num -2)
    }


fun main() {
    val N = sc.nextInt()
    println(fibo(N))
}