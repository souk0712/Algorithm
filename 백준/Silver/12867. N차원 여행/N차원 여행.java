import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        String dir = br.readLine();

        List<Map<Integer, Integer>> path = new ArrayList<>();
        Map<Integer, Integer> cur = new TreeMap<>(); // TreeMap으로 순서 보장

        path.add(new TreeMap<>(cur)); // 시작 위치 저장

        for (int i = 0; i < m; i++) {
            int d = Integer.parseInt(st.nextToken());
            char op = dir.charAt(i);
            int delta = (op == '+') ? 1 : -1;

            cur.put(d, cur.getOrDefault(d, 0) + delta);
            if (cur.get(d) == 0) cur.remove(d);

            for (Map<Integer, Integer> past : path) {
                if (past.equals(cur)) {
                    System.out.println(0);
                    return;
                }
            }

            path.add(new TreeMap<>(cur));
        }

        if (cur.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}