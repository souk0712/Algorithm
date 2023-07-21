class Solution {
    fun solution(arr: IntArray, n: Int): IntArray {
        return (if (arr.size % 2 == 1) arr.mapIndexed { index, i -> if (index % 2 == 0) i + n else i }
        else arr.mapIndexed { index, i -> if (index % 2 == 1) i + n else i }).toIntArray()
    }
}