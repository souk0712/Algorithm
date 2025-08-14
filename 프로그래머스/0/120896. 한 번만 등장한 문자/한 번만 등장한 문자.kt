class Solution {
    fun solution(s: String): String {
        return s.filter { alpha -> 
            s.count { it == alpha } == 1 
        }.toCharArray().sorted().joinToString("")
    }
}