import kotlin.math.abs

class Solution {
    fun solution(a: Int, b: Int): Int {
        return if (a % 2 == 1 && b % 2 == 1) {
            a * a + b * b
        } else if (a % 2 == 1 || b % 2 == 1) {
            2 * (a + b)
        } else {
            abs(a - b)
        }
    }
}