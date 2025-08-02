class Solution {
    fun solution(sides: IntArray): Int {
        var high = sides[0] + sides[1]
        var low = Math.abs(sides[0] - sides[1])

        return high - low - 1
    }
}