class Solution {
    fun solution(emergency: IntArray): IntArray {
        val answer = IntArray(emergency.size)
        var i = 1
        emergency.sortedDescending().forEach{ e ->
            emergency.indexOf(e)?.let{
                answer[it] = i++
            }
            
        }
        return answer
    }
}