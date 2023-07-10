class Solution {
    fun solution(my_string: String, is_suffix: String): Int {
        return if(my_string.indices.map(my_string::substring).contains(is_suffix))1 else 0
    }
}