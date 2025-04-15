import kotlin.math.max

fun main() {
    val expression = readLine()!!
    // Please write your code here.

    val letterRange = 'a' .. 'f' 
    val numberRange = 1 .. 4
    val letterCount = expression.count {
        it in letterRange
    }

    val operators = expression.filter {
        it !in letterRange
    }

    val letters = IntArray(letterCount) { 0 }
    var answer = Int.MIN_VALUE

    fun calculate(operand1: Int, operand2: Int, operator: Char): Int {
        return when (operator) {
            '+' -> operand1 + operand2
            '-' -> operand1 - operand2
            '*' -> operand1 * operand2
            else -> error("invalid operator")
        }
    }

    fun calculate(numbers: List<Int>): Int {
        var operIdx = 0

        if (numbers.size == 1) return numbers.first()

        var operand1 = numbers[operIdx]
        var operand2 = numbers[operIdx + 1]

        while (operIdx < operators.length) {
            operand2 = numbers[operIdx + 1]
            operand1 = calculate(operand1, operand2, operators[operIdx])
            operIdx++
        }

        return operand1
    }

    fun findMax(depth: Int, curNumbers: List<Int>) {
        if (depth >= letterCount) {
            answer = max(answer, calculate(curNumbers))
            return
        }

        for (number in numberRange) {
            findMax(depth + 1, curNumbers + number)
        }
    }

    findMax(0, emptyList())
    println(answer)
}