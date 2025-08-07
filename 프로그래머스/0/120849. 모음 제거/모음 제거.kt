class Solution {
    
    fun solution(my_string: String): String {
        val moeum = setOf('a','e','i','o','u')
        return my_string.filterNot { moeum.contains(it) }
    }
}