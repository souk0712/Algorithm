fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.toMutableList()

    fun binarySearch(dp: IntArray, target: Int, start: Int, end: Int, size: Int): Int {
        var res = 0
        var s = start
        var e = end
        while (s <= e) {
            val mid = (s + e) / 2
            if (target <= dp[mid]) {
                res = mid
                e = mid - 1
            } else {
                s = mid + 1
            }
        }
        return res.takeUnless { s == size } ?: -1
    }

    val upper = IntArray(n)
    var ulis = 0
    var ans = 0
    for (i in 0 until list.size) {
        val num = list.removeFirst()
        val idx = binarySearch(upper, num, 0, ulis, ulis + 1)
        if (idx == -1) {
            upper[ulis++] = num
        } else {
            upper[idx] = num
        }
        val lower = IntArray(n)
        var llis = 0
        for (j in list.size - 1 downTo 0) {
            if (num <= list[j]) continue
            val jj = binarySearch(lower, list[j], 0, llis, llis + 1)
            if (jj == -1) {
                lower[llis++] = list[j]
            } else {
                lower[jj] = list[j]
            }
        }
        ans = (ulis + llis).coerceAtLeast(ans)
    }
    println(ans)
}