class Solution {
    fun solution(q: Int, r: Int, code: String): String {
        return code.filterIndexed { index, c -> index % q == r }
    }
}