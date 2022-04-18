import kotlin.math.*

fun main() {
    val rule = readLine()!!.split(" ")
    val card = readLine()!!.split(" ")
    var result = 0
    val n = rule[0].toInt()
    val m = rule[1].toInt()
    for (x in 0 until n - 2)
        for (y in (x + 1) until n - 1)
            for (z in (y + 1) until n) {
                val sum = card[x].toInt() + card[y].toInt() + card[z].toInt()
                if (abs(m - result) > abs(m - sum) && sum <= m)
                    result = sum
            }
    print(result)
}