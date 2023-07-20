class Solution {
    fun solution(binomial: String): Int {
        val list = binomial.split(" ")
        return when (list[1]) {
            "+" -> {
                list[0].toInt() + list[2].toInt()
            }
            "-" -> {
                list[0].toInt() - list[2].toInt()
            }
            else -> {
                list[0].toInt() * list[2].toInt()
            }
        }
    }
}