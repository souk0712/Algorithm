class Solution {
    fun solution(my_string: String, m: Int, c: Int): String {
        return my_string.chunked(m).map { it[c-1] }.joinToString("")
    }
}