


fun main() {
    val icebergCount = readln().toInt()
    val icebergs = List(icebergCount) { readln().toInt() }

    val maxHeight = icebergs.maxOf { it }
    val seaLevels = 0 .. maxHeight - 1

    val maxIcebergCount = seaLevels.maxOf { seaLevel ->
        icebergs.foldIndexed(0) { i, count, iceberg -> 
            when {
                iceberg <= seaLevel -> count
                i == 0 || icebergs[i - 1] <= seaLevel -> count + 1
                else -> count
            }
        }
    }

    println(maxIcebergCount)
}
