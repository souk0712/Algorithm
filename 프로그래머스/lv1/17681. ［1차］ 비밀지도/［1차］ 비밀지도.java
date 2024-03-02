class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map = new int[n][n];
        for (int a = 0; a < n; a++) {
            int[] c1 = new int[n];
            int[] c2 = new int[n];
            String num1 = Integer.toBinaryString(arr1[a]);
            String num2 = Integer.toBinaryString(arr2[a]);
            char[] tmp1 = num1.toCharArray();
            for (int b = 0; b < tmp1.length; b++) {
                c1[b + n - tmp1.length] = tmp1[b] - '0';
            }
            char[] tmp2 = num2.toCharArray();
            for (int b = 0; b < tmp2.length; b++) {
                c2[b + n - tmp2.length] = tmp2[b] - '0';
            }
            for (int i = 0; i < n; i++) {
                map[a][i] = c1[i] | c2[i];
            }
        }
        int index = 0;
        for (int[] r : map) {
            StringBuilder sb = new StringBuilder();
            for (int c : r) {
                if (c == 1) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[index++] = sb.toString();
        }

        return answer;
    }
}