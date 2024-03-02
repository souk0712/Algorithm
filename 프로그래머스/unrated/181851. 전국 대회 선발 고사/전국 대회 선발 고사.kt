class Solution {
    fun solution(rank: IntArray, attendance: BooleanArray): Int {
        return rank.mapIndexed { i, v -> i to v }
            .filter { i -> attendance[i.first] }
            .sortedBy { it.second }
            .let { 10000 * it[0].first + 100 * it[1].first + it[2].first }
    }
}