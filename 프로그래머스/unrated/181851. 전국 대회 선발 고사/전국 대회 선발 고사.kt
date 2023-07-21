class Solution {
    fun solution(rank: IntArray, attendance: BooleanArray): Int {
        val a = rank.indices.map { rank[it] to it }.filter { i -> attendance[i.second] }.sortedBy { it.first }.take(3)
        return 10000 * a[0].second + 100 * a[1].second + a[2].second
    }
}