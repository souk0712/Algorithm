class Solution {
    fun solution(binomial: String): Int {
       return binomial.split(" ").let{ (a, o, b) ->
            when(o){
                "+" -> {
                    a.toInt() + b.toInt()
                }
                "-" -> {
                    a.toInt() - b.toInt()
                }
                "*" -> {
                    a.toInt() * b.toInt()
                }
                else -> 0
            }            
        }
    }
}