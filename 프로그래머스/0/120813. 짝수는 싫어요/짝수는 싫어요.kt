class Solution {
    fun solution(n: Int): IntArray {
        return (1..n).filterNot{it % 2 == 0}.toIntArray()
    }
}