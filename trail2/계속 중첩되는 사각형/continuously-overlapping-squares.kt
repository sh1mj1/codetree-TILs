const val OFFSET = 100
const val M_SIZE = 201

fun main() {
    val n = readln().toInt()
    
    val g = Array(M_SIZE) {
        IntArray(M_SIZE) { 0 }
    }
    
    var minX = 200
    var minY = 200
    var maxX = 0
    var maxY = 0
    
    var blueExist = false
    
    for (i in 1 .. n) {
        val nums = readln().trim().split(" ").map { it.toInt() + OFFSET }
        
        minX = minOf(minX, nums[0])
        minY = minOf(minY, nums[1])

        maxX = maxOf(maxX, nums[2])
        maxY = maxOf(maxY, nums[3])
        
        for (x in nums[0] until nums[2]) {
            for (y in nums[1] until nums[3]) {
                g[x][y] = i
                if (i % 2 == 0 && g[x][y] != 0) {
                    blueExist = true
                }
            }
        }
    }
    
    var ans = 0
    
    if (!blueExist) {
        println(0)
        return
    }
    
    for (x in minX until maxX) {
        for (y in minY until maxY) {
            if (g[x][y] % 2 == 0 && g[x][y] != 0) {
               ans++ 
            }
        }
    }
    
    println(ans)
}
