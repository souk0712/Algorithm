class Solution {
    fun solution(strArr: Array<String>): Array<String> {
        return strArr.filterNot { "ad" in it }.toTypedArray()
    }   
}