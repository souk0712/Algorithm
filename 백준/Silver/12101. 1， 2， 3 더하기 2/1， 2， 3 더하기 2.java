import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = {1, 2, 3};
    static int N, K;
    static ArrayList<String> list;
    static int[] pick;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        pick = new int[N];

        perm(0, 0);

        Collections.sort(list);
        System.out.println(list.size() > K - 1 ? list.get(K - 1) : -1);
    }

    private static void perm(int sum, int cnt) {
        if (sum >= N) {
            if (sum == N) {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < pick.length; i++) {
                    if (pick[i] != 0)
                        s.append(pick[i]).append("+");
                }
                s.deleteCharAt(s.length() - 1);
                list.add(s.toString());
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            pick[cnt] = arr[i];
            perm(sum + arr[i], cnt + 1);
            pick[cnt] = 0;
        }
    }
}