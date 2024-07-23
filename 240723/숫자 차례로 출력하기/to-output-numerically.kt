import java.util.*

val sc = Scanner(System.`in`)
val N = sc.nextInt()


fun recursiveUp(n: Int){
    if(n == 0) return

    recursiveUp(n-1)
    print("$n ")
}


fun recursiveDown(n: Int){
    if(n == 0) return

    print("$n ")
    recursiveDown(n-1)
}


fun main(){
    recursiveUp(N)
    println()
    recursiveDown(N)
}