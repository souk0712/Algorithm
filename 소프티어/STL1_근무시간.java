import java.util.*;
import java.io.*;


public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] hours = new int[2];
            int[] mins = new int[2];
            int index = 0;

            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                String[] arr = str.split(":");
                hours[index] = Integer.parseInt(arr[0]);
                mins[index] = Integer.parseInt(arr[1]);
                index++;
            }

            int res = mins[1] - mins[0];
            if (res >= 0) {
                ans += ((hours[1] - hours[0]) * 60 + res);
            } else {
                hours[1]--;
                ans += ((hours[1] - hours[0]) * 60 + (60 + res));
            }
        }

        System.out.println(ans);
    }
}