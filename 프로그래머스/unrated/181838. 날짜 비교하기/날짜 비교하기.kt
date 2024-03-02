class Solution {
    fun solution(date1: IntArray, date2: IntArray): Int {
        val list = intArrayOf(10000, 100, 1)
        var d1 = 0
        var d2 = 0
        list.forEachIndexed { index, i ->
            d1 += date1[index] * i
            d2 += date2[index] * i
        }
        return if (d1 < d2) 1 else 0
    }
}