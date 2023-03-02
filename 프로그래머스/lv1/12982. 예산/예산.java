import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
      int answer = 0;
        int n = d.length;
        Arrays.sort(d);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += d[i];
            if (sum > budget) {
                answer = i;
                break;
            }
        }
        if (sum <= budget) {
            answer = n;
        }
        return answer;
    }
}