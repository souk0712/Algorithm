class Solution {
    fun solution(myStr: String): Array<String> {
        return myStr.split("a", "b", "c").filter(String::isNotEmpty).let { it.ifEmpty { listOf("EMPTY") } }.toTypedArray()
    }
}