var ans = 0

val input1 = readln().split(" ").map{ it.toInt() }
val N = input1[0]
val K = input1[1]

val arr = IntArray(N+1) { 0 }

fun main() {
    repeat(K) {
        val input = readln().split(" ").map{ it.toInt() }
        val a = input[0]
        val b = input[1]
        for(i in a .. b) {
            arr[i]++
            if(ans < arr[i]) {
                ans = arr[i]
            }
        }
    }
    println(ans)
}