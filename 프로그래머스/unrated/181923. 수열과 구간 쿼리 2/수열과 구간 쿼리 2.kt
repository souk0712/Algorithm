class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        return queries.map { q ->
            (q[0]..q[1]).filter { arr[it] > q[2] }.minOfOrNull { arr[it] } ?: -1
        }.toIntArray()
    }
}