class Solution {
    fun solution(code: String): String = code.foldIndexed("" to 0) { idx, (ret, mode), c -> if(c == '1') ret to 1 - mode else if(mode == idx % 2) ret + c to mode else ret to mode }.first.ifEmpty {"EMPTY"}
}