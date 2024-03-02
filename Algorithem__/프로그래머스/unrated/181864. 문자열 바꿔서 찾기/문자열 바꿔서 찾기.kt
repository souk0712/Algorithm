class Solution {
    fun solution(myString: String, pat: String): Int {
        return myString.map { if (it == 'A') 'B' else 'A' }.joinToString("").contains(pat).let {
            if (it) 1 else 0
        }
    }
}