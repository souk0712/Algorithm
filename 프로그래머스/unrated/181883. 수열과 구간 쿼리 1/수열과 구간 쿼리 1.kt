class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        queries.forEach { ints: IntArray ->
            (ints[0]..ints[1]).forEach { arr[it] += 1 }
        }
        return arr
    }
}