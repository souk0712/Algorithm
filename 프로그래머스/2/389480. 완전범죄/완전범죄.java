import java.io.*;
import java.util.*;

class Solution {

    public int solution(int[][] info, int n, int m) {
        final int INF = Integer.MAX_VALUE / 2;

        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < info.length; i++) {
            int aVal = info[i][0];
            int bVal = info[i][1];

            int[] next = new int[m];
            Arrays.fill(next, INF);

            for (int b = 0; b < m; b++) {
                if (dp[b] >= INF) continue;

                if (dp[b] + aVal < n) {
                    next[b] = Math.min(next[b], dp[b] + aVal);
                }

                if (b + bVal < m) {
                    next[b + bVal] = Math.min(next[b + bVal], dp[b]);
                }
            }

            dp = next;
        }

        int ans = INF;
        for (int b = 0; b < m; b++) {
            ans = Math.min(ans, dp[b]);
        }
        return ans < INF ? ans : -1;
    }
}