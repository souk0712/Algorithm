class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray = arr.apply {
        queries.forEach { (s, e, k) ->
            (s..e).filter { it % k == 0 }.forEach {
                arr[it] += 1
            }
        }
    }
}