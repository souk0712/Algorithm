class Solution {
    fun solution(order: Array<String>): Int {
        var answer = 0
        order.forEach { menu ->
            answer += when (menu) {
                "hotcafelatte", "cafelattehot", "cafelatte", "icecafelatte", "cafelatteice" -> {
                    5000
                }
                else -> {
                    4500
                }
            }
        }
        return answer
    }
}