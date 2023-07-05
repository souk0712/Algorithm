class Solution {
    fun solution(ineq: String, eq: String, n: Int, m: Int): Int {
        return if(
            when(ineq){
            "<" -> {
                if(eq == "=") n <= m else n < m                
            }
            else -> {
                if(eq == "=") n >= m else n > m    
            }
        }) 1 
        else 0
    }
}