class Solution {
    fun solution(arr: IntArray, query: IntArray): IntArray {
        var answer = arr.clone()
        query.forEachIndexed { index, i ->
            val size = answer.size
            answer = if(index % 2 == 0){
                answer.take(i + 1).toIntArray()
            } else {
                answer.takeLast(size - i).toIntArray()
            }
        }
        return answer
    }
}