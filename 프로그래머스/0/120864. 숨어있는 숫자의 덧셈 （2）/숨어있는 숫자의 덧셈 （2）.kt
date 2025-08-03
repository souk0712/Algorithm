class Solution {
    fun solution(my_string: String): Int {
        return my_string.split("[^0-9]".toRegex())
            .sumOf{ it.toIntOrNull() ?: 0 }
    }
}