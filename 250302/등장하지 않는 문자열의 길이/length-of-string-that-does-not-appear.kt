


fun main() {
    val count = readln().toInt()
    val str = readln()

    for(l in 1 until count) {
        val windows = str.windowed(l)
        if (windows.count() == windows.toSet().count()) {
            println(l)
            break
        }
    }
    
}