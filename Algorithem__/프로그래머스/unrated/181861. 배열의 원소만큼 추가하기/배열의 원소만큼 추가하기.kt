class Solution {
    fun solution(arr: IntArray): IntArray {
        return arr.flatMap { i -> List(i) { i } }.toIntArray()
    }
}