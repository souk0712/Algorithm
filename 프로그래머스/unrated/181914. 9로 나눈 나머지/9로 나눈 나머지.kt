class Solution {
    fun solution(number: String): Int {
        return number.fold(0) { acc, s -> acc + (s.code - '0'.code) } % 9
    }
}