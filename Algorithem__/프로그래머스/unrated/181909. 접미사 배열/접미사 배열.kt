class Solution {
    fun solution(my_string: String): Array<String> {
        return my_string.mapIndexed{ index, _ ->  my_string.takeLast(index + 1)}.sorted().toTypedArray()
    }
}