class Solution {
    fun solution(arr: IntArray, delete_list: IntArray): IntArray {
        return (arr.toList() - delete_list.toList()).toIntArray()
    }
}