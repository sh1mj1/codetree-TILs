val N = readln().toInt()
val arr = IntArray(21) { 0 }


fun f(num: Int): Int {

    if(arr[num] != 0)
        return arr[num]
    
    arr[num] = f(num-2) * f(num-1) % 100
    return arr[num]
}

fun main() {
    arr[1] = 2
    arr[2] = 4

    println(f(N))
}