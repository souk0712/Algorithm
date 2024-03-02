import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<int[]> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new int[]{a, b});
            }
            list.sort((o1, o2) -> Integer.compare(o1[0], o2[0]));

            int count = 1;
            int target = list.get(0)[1];
            for (int i = 1; i < N; i++) {
                int ii = list.get(i)[1];
                if (target > ii) {
                    count++;
                    target = ii;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}