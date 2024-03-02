class Solution {
    fun solution(num_list: IntArray): IntArray {
        val answer = num_list.clone()
        val a = num_list.toList().takeLast(2)
        return answer.plus(if (a.get(0) < a.get(1)) a.get(1) - a.get(0) else a.get(1) * 2)
    }
}