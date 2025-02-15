

fun main() {
    val n = readln().toInt()
    val cowsHeight = readln().trim().split(" ").map(String::toInt)
    val lastIdx = cowsHeight.size - 1

    val count = cowsHeight.withIndex().sumOf { (i, iHeight) ->
        (i + 1 .. lastIdx).sumOf { j -> 
            (j + 1 .. lastIdx).count { k ->
                iHeight <= cowsHeight[j] && cowsHeight[j] <= cowsHeight[k]
            }
        }
    }
    
    println(count)
}