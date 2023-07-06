class Solution {
    fun solution(arr: IntArray): IntArray {
        val stk: MutableList<Int> = mutableListOf()
        var i = 0
        while (i < arr.size) {
            if (stk.isEmpty()) {
                stk.add(arr[i++])
            } else if (stk.last() < arr[i]) {
                stk.add(arr[i++])
            } else {
                stk.removeLast()
            }
        }
        return stk.toIntArray()
    }
}