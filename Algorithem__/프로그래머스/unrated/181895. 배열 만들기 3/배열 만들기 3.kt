class Solution {
    fun solution(arr: IntArray, intervals: Array<IntArray>): IntArray {
        return arr.sliceArray(intervals[0][0]..intervals[0][1]) + arr.sliceArray(intervals[1][0]..intervals[1][1])
    }
}