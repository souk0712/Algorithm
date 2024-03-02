class Solution {
    public int[] solution(int[] sequence, int k) {
      int[] answer = {};
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = sequence[0];
        while (start < sequence.length) {
            if (sum == k) {
                int length = end - start - 1;

                if (length < min) {
                    min = length;
                    answer = new int[]{start, end};
                }
                if (end >= sequence.length - 1)
                    sum -= sequence[start++];
                else
                    sum += sequence[++end];

            } else if (end >= sequence.length - 1 || sum > k) {
                sum -= sequence[start++];

            } else {
                sum += sequence[++end];
            }
        }

        return answer;

    }
}