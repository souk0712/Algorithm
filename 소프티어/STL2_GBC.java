import java.util.*;
import java.io.*;


public class Main {
    static int N, M;
    static int[] NArr;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        NArr = new int[101];
        int max = 0;

        int temp = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            for (int j = temp + 1; j <= temp + l; j++) {
                NArr[j] = s;
            }
            temp += l;
        }

        temp = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            for (int j = temp + 1; j <= temp + l; j++) {
                int diff = s - NArr[j];
                max = Math.max(max, diff);
            }
            temp += l;
        }

        System.out.println(max);
    }
}