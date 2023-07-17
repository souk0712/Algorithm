class Solution {
    fun solution(myString: String, pat: String): Int {
        return if (myString.uppercase().contains(pat.uppercase())) 1 else 0
    }
}