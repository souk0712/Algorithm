class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        queries.map { q ->
            (q[0]..q[1]).filter { it % q[2] == 0 }.forEach {
                arr[it] += 1
            }
        }
        return arr
    }
}