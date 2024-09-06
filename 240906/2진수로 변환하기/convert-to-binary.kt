var n = readln().toInt()

val remainders = mutableListOf<Int>()

fun main() {
    while(n != 0) {
        val remainder = n % 2
        n = n / 2
        remainders.add(remainder)
   }
   for(item in remainders.reversed()) {
        print(item)
   }
}