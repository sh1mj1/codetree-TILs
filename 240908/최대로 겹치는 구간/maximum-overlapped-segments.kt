// 점은 -100 ~ 100 까지 찍힐 수 있ㅇㅁ.
// -> 점 찍힐 때 100 씩 더하기.

val n = readln().toInt()

val interval = IntArray(202) { 0 }
var ans = 0

fun main() {
    repeat(3) {
        val line = readln().split(" ").map { it.toInt() }
        val x1 = line[0] + 100
        val x2 = line[1] + 100
        for(i in x1+1 .. x2) {
            interval[i]++
            if(ans < interval[i]) {
                ans++
            }
        }
    }
    println(ans)
}