class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
         var answer: Int = 0
        // col에 해당하는 컬럼을 기준으로 오름차순 정렬
        // 같을 시, 첫번째 컬럼 값 기준으로 내림차순 정렬
        data.sortWith(Comparator { o1, o2 ->
            val compare = o1[col - 1].compareTo(o2[col - 1])
            if (compare == 0) o2[0].compareTo(o1[0])
            else compare
        })

        // row_begin번째 <= i <= row_end번째 행의 mod i
        for (i in row_begin - 1 until row_end) {
            var sum = 0
            for (j in 0 until data[i].size) {
                sum += data[i][j] % (i + 1)
            }
            // 누적 S_i XOR
            answer = answer.xor(sum)
        }
        
        return answer
    }
}