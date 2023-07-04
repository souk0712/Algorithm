import kotlin.math.max

class Solution {
    fun solution(a: Int, b: Int): Int {
        return max("$a$b".toInt(),"$b$a".toInt())
    }
}