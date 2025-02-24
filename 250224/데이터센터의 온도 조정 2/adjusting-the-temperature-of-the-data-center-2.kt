

fun main() {
    val info = readln().trim().split(" ").map(String::toInt)
    val machineCount = info[0]
    val work1 = info[1]
    val work2 = info[2]
    val work3 = info[3]

    val machines = List(machineCount) {
        readln().trim().split(" ").map(String::toInt).let {
            Machine(it[0], it[1])
        }
    }

    val lowestTemperature = machines.minOf { it.lowTemperature }
    val highestTemperature = machines.maxOf { it.highTemperature }

    val maxWorkAmount = (lowestTemperature - 1 .. highestTemperature + 1).maxOf { temperature ->
        machines.sumOf { machine ->
            machine.workAmount(temperature, work1, work2, work3)
        }
    }

    println(maxWorkAmount)

}

data class Machine(
    val lowTemperature: Int,
    val highTemperature: Int,
 ) {
    fun workAmount(temperature: Int, work1: Int, work2: Int, work3: Int): Int {
        if (temperature < lowTemperature) return  work1
        if (temperature > highTemperature) return work3
        return work2
    }
}
