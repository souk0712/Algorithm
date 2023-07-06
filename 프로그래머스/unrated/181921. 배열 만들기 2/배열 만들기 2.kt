class Solution {
    fun solution(l: Int, r: Int): IntArray {
        var answer: IntArray = intArrayOf()
        
        for(i in l..r){
            var check = false
            i.toString().forEach { c ->
                if(c != '5' && c != '0'){
                    check = true
                }
            }
            if(!check) answer += i
        }
        
        if(answer.isEmpty()){
            answer += -1
        }
        
        return answer
    }
}