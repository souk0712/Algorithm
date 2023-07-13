class Solution {
    fun solution(arr: IntArray, intervals: Array<IntArray>): IntArray {
        return intervals.flatMap { ints ->  arr.slice(IntRange(ints[0],ints[1]))}.toIntArray()
    }
}