


fun main() {
    val icebergCount = readln().toInt()
    val icebergs = List(icebergCount) { readln().toInt() }

    val maxHeight = icebergs.maxOf { it }
    val searchRange = 0 .. maxHeight - 1

    val maxIcebergCount = searchRange.maxOf { seaLevel ->
        var count = 0
        icebergs.forEachIndexed { i, iceberg -> 
            if (iceberg <= seaLevel) return@forEachIndexed

            if (i == 0) {
                count++
                return@forEachIndexed
            }

            if (icebergs[i - 1] <= seaLevel) {
                count++
                return@forEachIndexed
            }

        }
        count
    }

    println(maxIcebergCount)
}
