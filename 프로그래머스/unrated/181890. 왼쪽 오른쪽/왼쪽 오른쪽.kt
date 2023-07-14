class Solution {
    fun solution(str_list: Array<String>): Array<String> {
        var answer = listOf<String>()
        for (i in str_list.indices) {
            if (str_list[i] == "l") {
                answer = str_list.take(i)
                break
            } else if (str_list[i] == "r") {
                answer = str_list.takeLast(str_list.size - (i + 1))
                break
            }
        }
        return answer.toTypedArray()
    }
}