val n = readln().toInt()
val inputArr = readln().split(" ").map { it.toInt() }.toIntArray()

fun main() {
    if(n == 1) {
        println(inputArr[0])
    } else {
        println(f(1))
    }
}

fun f(idx: Int) : Int {
    if(idx == inputArr.size - 1) {
        return lcm(inputArr[idx -1], inputArr[idx])
    }

    inputArr[idx] = lcm(inputArr[idx-1], inputArr[idx])
    return f(idx+1)
}


fun lcm(x: Int, y: Int) : Int {
    var (big, small) = bigAndSmall(x, y)
    var res = big * small

    for(divider in small downTo 2) {
        if(
            small % divider == 0 &&
            big % divider == 0
        ) {
            big = big / divider
            small = small / divider
            res = divider * big * small
            break
        }
    }
    return res
}

fun bigAndSmall(x: Int, y: Int): Pair<Int, Int>{
    if(x >= y) return Pair(x, y)
    return Pair(y, x)
}