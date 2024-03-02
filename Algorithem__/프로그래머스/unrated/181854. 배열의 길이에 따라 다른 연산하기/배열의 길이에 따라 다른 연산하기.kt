class Solution {
    fun solution(arr: IntArray, n: Int): IntArray {
        return arr.indices.map { arr[it] + if (it % 2 == if (arr.size % 2 == 0) 1 else 0) n else 0 }.toIntArray()
    }
}