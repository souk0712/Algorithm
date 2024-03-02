class Solution {
    fun solution(myString: String): String {
        return myString.fold("") { acc, c ->
            acc + if (c < 'l') {
                'l'
            } else {
                c
            }
        }
    }
}