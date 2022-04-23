package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java3985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int[] cake = new int[l];
        int n = Integer.parseInt(br.readLine());
        int[] pro = new int[2];
        int[] take = new int[n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            int p = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int j = p - 1; j < k; j++) {
                if (cake[j] == 0) {
                    cake[j] = i + 1;
                    take[i]++;
                }

                if (pro[1] < k - p+1) {
                    pro[0] = i + 1;
                    pro[1] = k - p+1;
                }
            }
        }

        System.out.println(pro[0]);

        int index = 0;
        int max = 0;
        for (int i = 0; i < take.length; i++) {
            if (take[i] > max) {
                max = take[i];
                index = i + 1;
            }
        }
        System.out.println(index);

    }
}
