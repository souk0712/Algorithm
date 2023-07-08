class Solution {
    fun solution(my_string: String, queries: Array<IntArray>): String {
        var answer = my_string
        queries.forEach { (first, second) ->
            val rev = answer.slice(first..second).reversed()
            answer = answer.replaceRange(first..second, rev)
        }
        return answer
    }
}