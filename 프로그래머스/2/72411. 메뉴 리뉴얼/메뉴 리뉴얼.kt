class Solution {
    // 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성
    // 단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성
    // 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함
    
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val answer = mutableListOf<String>()
        course.forEach { count ->
            val combination = mutableListOf<String>()
            orders.forEach { order ->
                val orderCharArray = order.toCharArray().sortedArray()
                val visit = BooleanArray(orderCharArray.size)
                val result = CharArray(count)
                comb(orderCharArray, visit, 0, count, 0, result, combination)
            }
            val result = combination.groupingBy { it }.eachCount()
            val maxValue = result.maxOfOrNull { it.value }
            answer.addAll(result.filter { it.value == maxValue && it.value >= 2 }.map { it.key })
        }
        // 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬
        // 배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬
        // 만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아
        return answer.sorted().toTypedArray()
    }

    fun comb(
        array: CharArray,
        visit: BooleanArray,
        start: Int,
        totalCount: Int,
        cnt: Int,
        result: CharArray,
        list: MutableList<String>
    ) {
        if (cnt == totalCount) {
            list.add(result.joinToString(""))
            return
        }
        for (i in start until array.size) {
            if (visit[i]) continue
            visit[i] = true
            result[cnt] = array[i]
            comb(array, visit, i + 1, totalCount, cnt + 1, result, list)
            visit[i] = false
        }
    }
}