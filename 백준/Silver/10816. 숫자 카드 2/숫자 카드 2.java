import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map<Long, Long> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long l = Long.parseLong(st.nextToken());
            if (map.containsKey(l)) {
                map.put(l, map.get(l) + 1);
            } else {
                map.put(l, 1L);
            }
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            long l = Long.parseLong(st.nextToken());
            if (map.containsKey(l)) {
                sb.append(map.get(l)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}