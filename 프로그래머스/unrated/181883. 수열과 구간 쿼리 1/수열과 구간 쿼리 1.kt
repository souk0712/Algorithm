class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        queries.forEach { ints: IntArray ->
            for (i in arr.indices) {
                if (i in (ints[0]..ints[1])) {
                    arr[i]++
                }
            }
        }
        return arr
    }
}