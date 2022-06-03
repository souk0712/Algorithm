package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Java1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] result = new int[N];
        List<Integer> list = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int pt = 0;
        for (int i = 0; i < N; i++) {
            pt = (pt + (K - 1)) % list.size();
            result[i] = list.get(pt);
            list.remove(pt);

        }

        System.out.print("<");

        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1)
                System.out.print(result[i]);
            else
                System.out.print(result[i] + ", ");
        }
        System.out.print(">\n");
    }
}
