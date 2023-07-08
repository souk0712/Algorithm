class Solution {
    fun solution(my_string: String, index_list: IntArray): String = index_list.fold("") { acc, i -> acc + my_string[i] }
}