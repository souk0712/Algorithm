class Solution {
    fun solution(arr: IntArray, delete_list: IntArray): IntArray {
        val answer = arr.copyOf().toMutableList()
        delete_list.forEach {
            answer.remove(it)
        }
        return answer.toIntArray()
    }
}