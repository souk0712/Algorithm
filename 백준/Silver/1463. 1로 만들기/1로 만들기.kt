fun main() {
    //정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지
    //X가 3으로 나누어 떨어지면, 3으로 나눈다.
    //X가 2로 나누어 떨어지면, 2로 나눈다.
    //1을 뺀다.
    val INF = 1_000_000
    val n = readln().toInt()
    val dp = IntArray(INF+1) { INF }
    dp[1] = 0
    for (i in 2 .. INF) {
        if (i % 2 == 0) {
            dp[i] = dp[i].coerceAtMost(dp[i / 2] + 1)
        }
        if (i % 3 == 0) {
            dp[i] = dp[i].coerceAtMost(dp[i / 3] + 1)
        }
        dp[i] = dp[i].coerceAtMost(dp[(i - 1)] + 1)
    }
    println(dp[n])
}