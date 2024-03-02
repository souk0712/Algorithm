class Solution {
    fun solution(myString: String, pat: String): Int {
        return if(myString.uppercase(Locale.getDefault()).contains(pat.uppercase(Locale.getDefault()))) 1 else 0
    }
}