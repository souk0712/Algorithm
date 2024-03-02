package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java1859 {
    static Long total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int value = 0;
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            int[] num = new int[N];
            int[] max = new int[2];

            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
                if (num[i] > max[1]) {
                    max[0] = i;
                    max[1] = num[i];
                }
            }

            for (int i = 0; i < max[0]; i++) {
                value += (-num[i]);
            }
            total = ((long) max[0] * num[max[0]] + value);

            if (max[0] != N - 1)
                fun1(N, max[0], num);

            System.out.println("#" + (t + 1) + " " + total);
        }
    }

    static void fun1(int N, int index, int[] num) {
        if (index == N - 1) return;
        int mIndex = index + 1;
        int[] max = new int[2];
        int value = 0;
        for (int i = mIndex; i < N; i++) {
            if (num[i] > max[1]) {
                max[0] = i;
                max[1] = num[i];
            }
        }
        for (int i = mIndex; i < max[0]; i++) {
            value += (-num[i]);
        }
        total += (long) (max[0] - mIndex) * num[max[0]] + value;
        fun1(N, max[0], num);
    }
}
