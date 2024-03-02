fun main() {
    val a = readln()
    val b = readln()
    val dp = Array(a.length + 1) { IntArray(b.length + 1) }
    val dx = intArrayOf(-1, 0)
    val dy = intArrayOf(0, -1)

    for (i in 1..a.length) {
        for (j in 1..b.length) {
            if (a[i - 1] == b[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = dp[i - 1][j].coerceAtLeast(dp[i][j - 1])
            }
        }
    }

    val ans = CharArray(dp[a.length][b.length])
    val q = ArrayDeque<IntArray>()
    q.add(intArrayOf(a.length, b.length))
    var index = 0
    while (!q.isEmpty()) {
        val cur = q.removeFirst()
        var check = true
        if (index == dp[a.length][b.length]) {
            break
        }
        for (k in dx.indices) {
            val mx = cur[0] + dx[k]
            val my = cur[1] + dy[k]
            if (mx <= 0 || my <= 0 || mx > a.length || my > b.length) continue
            if (dp[cur[0]][cur[1]] == dp[mx][my]) {
                q.add(intArrayOf(mx, my))
                check = false
                break
            }
        }
        if (check) {
            q.add(intArrayOf(cur[0] - 1, cur[1] - 1))
            ans[index++] = a[cur[0] - 1]
        }
    }

    println(dp[a.length][b.length])
    println(ans.reversedArray())
}