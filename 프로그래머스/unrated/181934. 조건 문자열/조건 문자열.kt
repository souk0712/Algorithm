class Solution {
    fun solution(ineq: String, eq: String, n: Int, m: Int): Int {
        return when{
            ineq == "<" && eq == "=" -> n <= m
            ineq == "<" && eq == "!" -> n < m
            ineq == ">" && eq == "=" -> n >= m
            ineq == ">" && eq == "!" -> n > m
            else -> false
        }.let{
            if(it) 1 else 0
        }
    }
}