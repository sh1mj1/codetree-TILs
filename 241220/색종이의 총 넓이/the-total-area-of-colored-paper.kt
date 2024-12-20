fun main(){
    val papersCount = readln().toInt()
    val papers = Papers(List(papersCount) {
        val (x, y) = readln().split(" ").map{it.toInt()}
        Paper(bottomLeft = Vertex(x, y))
    })
    println(papers.area())
}

data class Vertex(val x: Int, val y: Int)

data class Paper(val bottomLeft: Vertex){
    val topRight: Vertex = Vertex(
        bottomLeft.x + 8, bottomLeft.y + 8
    )
}

data class Papers(val papers: List<Paper>) {
    fun area(): Int {
        var area = 0
        val totalArea = Array(200) {
            BooleanArray(200) {false}
        }
        val offset = 100

        papers.forEach { paper ->
            with(paper) {
                for(x in bottomLeft.x until topRight.x) {
                    for(y in bottomLeft.y until topRight.y) {
                        totalArea[x + 100][y + 100] = true
                    }
                }
            }
        }

        return totalArea.sumOf { row -> row.count{ it } }
    }
}
