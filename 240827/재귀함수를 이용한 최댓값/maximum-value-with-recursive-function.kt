import java.util.*

val sc = Scanner(System.`in`)

val count = sc.nextInt()
var max = 1

var idx = 0
val arr = Array(count) { sc.nextInt() }

fun f(num: Int): Int {
    if(num > max) {
        max = num
    }
    idx++
    if(idx < arr.size) return f(arr[idx])
    return max
}

fun main() {
    println(f(arr[0]))
}