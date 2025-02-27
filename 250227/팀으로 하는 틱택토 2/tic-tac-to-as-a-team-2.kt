fun main() {
    val map = List(3) { readln() } // 3x3 문자열 입력 받기

    var answer = 0

    for (i in 1..9) {
        for (j in i + 1..9) {
            var success = false

            // Case 1: 가로 확인
            for (row in 0..2) {
                if (success) break
                val countI = map[row].count { it == '0' + i }
                val countJ = map[row].count { it == '0' + j }

                if (countI > 0 && countJ > 0 && countI + countJ == 3) success = true
            }
            if (success) {
                answer++
                continue
            }

            // Case 2: 세로 확인
            for (col in 0..2) {
                if (success) break
                val countI = (0..2).count { map[it][col] == '0' + i }
                val countJ = (0..2).count { map[it][col] == '0' + j }

                if (countI > 0 && countJ > 0 && countI + countJ == 3) success = true
            }
            if (success) {
                answer++
                continue
            }

            // Case 3: 왼쪽 위 → 오른쪽 아래 대각선 확인
            val countDiagI = (0..2).count { map[it][it] == '0' + i }
            val countDiagJ = (0..2).count { map[it][it] == '0' + j }
            if (countDiagI > 0 && countDiagJ > 0 && countDiagI + countDiagJ == 3) {
                answer++
                continue
            }

            // Case 4: 오른쪽 위 → 왼쪽 아래 대각선 확인
            val countAntiDiagI = (0..2).count { map[it][2 - it] == '0' + i }
            val countAntiDiagJ = (0..2).count { map[it][2 - it] == '0' + j }
            if (countAntiDiagI > 0 && countAntiDiagJ > 0 && countAntiDiagI + countAntiDiagJ == 3) {
                answer++
            }
        }
    }

    println(answer)
}