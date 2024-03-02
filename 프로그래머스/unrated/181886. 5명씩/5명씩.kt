class Solution {
    fun solution(names: Array<String>): Array<String> {
        return names.toList().chunked(5).map { it[0] }.toTypedArray()
    }
}