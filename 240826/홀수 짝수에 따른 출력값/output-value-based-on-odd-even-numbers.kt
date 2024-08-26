import java.util.Scanner

val sc = Scanner(System.`in`)

fun f(num: Int): Int = 
    when(num) {
        1 -> 1
        2 -> 2
        else -> num + f(num -2)   
    }

fun main() {
    val N = sc.nextInt()
    println(f(N))
}