class Solution {
    fun solution(a: Int, b: Int, c: Int): Int {
        return when (setOf(a, b, c).size) {
            1 -> (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c)
            2 -> (a + b + c) * (a * a + b * b + c * c)
            else -> a + b + c
        }
    }
}