class Solution {
    fun solution(n: Int): Int {
        return (1 .. n).fold(0){total, acc -> if (acc % 2 == 0) total + acc else total}
    }
}