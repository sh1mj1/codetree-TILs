import java.util.*

val sc = Scanner(System.`in`)
val N = sc.nextInt()

val sb = StringBuilder()

fun recursiveUpTo(n: Int){
    if(n == N + 1){
        sb.append("\n")
        return
    }
    sb.append("$n ")
    recursiveUpTo(n+1)
}


fun recursiveDownTO(n: Int){
    if(n ==0){
        sb.append("\n")
        return
    }
    sb.append("$n ")
    recursiveDownTO(n-1)
}


fun main(){
    recursiveUpTo(1)
    recursiveDownTO(N)

    println(sb.toString())

}