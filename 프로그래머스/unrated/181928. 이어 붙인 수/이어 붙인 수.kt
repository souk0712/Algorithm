class Solution {
    fun solution(num_list: IntArray): Int {
        return num_list.filter{ it % 2 == 0 }.fold("") {acc, i -> acc + i}.toInt() + num_list.filter{ it % 2 == 1 }.fold(""){acc, i -> acc + i}.toInt()
    }
}