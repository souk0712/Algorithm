class Solution {
    fun solution(my_string: String): Int {
        return my_string.replace(Regex("[^0-9]"), " ").split(" ").filter {it != ""}.map{it.toInt()}.sum()
    }
}