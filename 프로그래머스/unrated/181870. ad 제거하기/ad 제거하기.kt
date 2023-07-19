class Solution {
    fun solution(strArr: Array<String>): Array<String> {
        return strArr.filterNot { it.contains("ad") }.toTypedArray()
    }
}