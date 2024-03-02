class Solution {
    fun solution(myString: String, pat: String): String {
        return myString.take(myString.lastIndexOf(pat) + pat.length)
    }
}