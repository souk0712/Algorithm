class Solution {
    fun solution(numbers: IntArray, n: Int): Int {
        return numbers.fold(0) { acc, i -> if (acc > n) acc else acc + i }
    }
}