import java.util.*
import java.io.*

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val restaurantCount = bufferedReader.readLine().toInt()
    val restaurantCustomerToken = StringTokenizer(bufferedReader.readLine())

    val restaurantCustomers = MutableList(restaurantCount) {
        restaurantCustomerToken.nextToken().toInt()
    }

    val workerToken = StringTokenizer(bufferedReader.readLine())
    val leaderCapacity = workerToken.nextToken().toInt()
    val memberCapacity = workerToken.nextToken().toInt()

    var answer: Long = restaurantCount.toLong()

    for (customer in restaurantCustomers) {
        var remainedCustomer = customer - leaderCapacity
        if (remainedCustomer <= 0) {
            remainedCustomer = 0
            continue
        }
        
        answer += (remainedCustomer / memberCapacity)
        if (remainedCustomer % memberCapacity > 0) answer++
    }

    bufferedWriter.write("$answer")

    bufferedWriter.flush()
    bufferedWriter.close()
}
