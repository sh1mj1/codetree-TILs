val N = readln().toInt()
val arr = IntArray(16) { 0 }

fun main() {
    arr[1] = 1
    arr[2] = 2

    println(f(N))
}

fun f(num: Int): Int {
    if(arr[num] != 0 ) return arr[num]

    arr[num] = f(num/3) + f(num-1)
    return arr[num]
}