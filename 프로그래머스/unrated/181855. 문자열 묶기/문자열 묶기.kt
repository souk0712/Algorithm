class Solution {
    fun solution(strArr: Array<String>): Int {
        return strArr.groupingBy(String::length).eachCount().maxOf { it.value }
    }
}