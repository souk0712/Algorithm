class Solution {
    fun solution(n: Int, slicer: IntArray, num_list: IntArray): IntArray {
        return when (n) {
            1 -> {
                (0..slicer[1]).map { num_list[it] }
            }
            2 -> {
                (slicer[0]..num_list.lastIndex).map { num_list[it] }
            }
            3 -> {
                (slicer[0]..slicer[1]).map { num_list[it] }
            }
            else -> {
                (slicer[0]..slicer[1] step slicer[2]).map { num_list[it] }
            }
        }.toIntArray()
    }
}