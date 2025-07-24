class Solution {
    fun solution(strlist: Array<String>): IntArray {
        var answer = IntArray(strlist.size)
        for(i in 0 until strlist.size){
            answer[i] = strlist[i].length
        }
        return answer
    }
}