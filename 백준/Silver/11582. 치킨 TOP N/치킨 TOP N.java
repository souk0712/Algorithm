import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static ArrayList<Integer> arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        K = Integer.parseInt(br.readLine());

        int length = N / K;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i += length) {
            ArrayList<Integer> tmp = new ArrayList<>(arr.subList(i, i + length));
            Collections.sort(tmp);
            ans.addAll(tmp);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}