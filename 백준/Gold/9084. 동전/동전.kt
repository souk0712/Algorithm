fun main() {
    val t = readln().toInt();

    for (i in 0 until t) {
        val n = readln().toInt()
        val list = readln().split(" ").map { it.toInt() }
        val money = readln().toInt()
        val dp = IntArray(money + 1)
        dp[0] = 1
        for (j in 0 until n) {
            for (k in list[j] until money + 1) {
                dp[k] = dp[k] + dp[k - list[j]]
            }
        }
        println(dp[money])
    }
}