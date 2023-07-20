class Solution {
    fun solution(arr: IntArray, k: Int): IntArray {
        val new = arr.distinct()
        return (0 until k).map { if (it >= new.size) -1 else new[it] }.toIntArray()
    }
}