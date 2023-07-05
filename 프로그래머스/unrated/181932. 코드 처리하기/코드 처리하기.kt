class Solution {
    fun solution(code: String): String {
        var answer =""
        var mode = 0
        code.forEachIndexed { idx, c ->
            if(c == '1'){
                if(mode==1) mode = 0 else mode =1
            }else{
                if(mode == 0 && idx % 2 == 0){
                    answer += c
                }else if(mode == 1 && idx %2 != 0){
                    answer += c
                }
            }
        }
        return if(answer.isEmpty()) "EMPTY" else answer
    }
}