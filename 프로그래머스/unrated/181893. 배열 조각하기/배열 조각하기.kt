class Solution {
    fun solution(arr: IntArray, query: IntArray): IntArray {
        val res = query.withIndex()
            .fold(arr) { acc, (i, e) ->
                if (i % 2 == 0) {
                    acc.copyOfRange(0, e + 1)
                } else {
                    acc.copyOfRange(e, acc.size)
                }
            }
        return if (res.isEmpty()) intArrayOf(-1) else res
    }
}