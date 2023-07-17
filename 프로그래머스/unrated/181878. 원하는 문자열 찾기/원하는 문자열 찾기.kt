class Solution {
    fun solution(myString: String, pat: String): Int {
        return if(myString.toUpperCase().contains(pat.toUpperCase())) 1 else 0
    }
}