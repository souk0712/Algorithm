class Solution {
    fun solution(my_strings: Array<String>, parts: Array<IntArray>): String {
        return my_strings.indices.joinToString(""){ my_strings[it].substring(parts[it][0]..parts[it][1]) }
    }
}