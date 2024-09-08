val n = readln().toInt()

val interval = IntArray(101) { 0 }
var ans = 0

fun main() {
    repeat(n) {
        val line = readln().split(" ").map { it.toInt() }
        val x1 = line[0]
        val x2 = line[1]
        for(i in x1 .. x2) {
            interval[i]++
            if(ans < interval[i]) {
                ans++
            }
        }
    }
    println(ans)
}