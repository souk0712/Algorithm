class Solution {
    fun solution(myString: String): Array<String> {
        return myString.split('x').filterNot{it.isEmpty()}.sorted().toTypedArray()
    }
}