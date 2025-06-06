import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String dir = br.readLine();

        List<Map<Integer, Integer>> path = new ArrayList<>();
        Map<Integer, Integer> cur = new HashMap<>();

        path.add(new HashMap<>(cur));

        for (int i = 0; i < m; i++) {
            int index = Integer.parseInt(st.nextToken());
            char c = dir.charAt(i);
            int value = c == '+' ? 1 : -1;

            cur.put(index, cur.getOrDefault(index, 0) + value);

            if (cur.get(index) == 0) {
                cur.remove(index);
            }

            for (Map<Integer, Integer> map : path) {
                if (map.equals(cur)) {
                    System.out.println(0);
                    return;
                }
            }

            path.add(new HashMap<>(cur));
        }

        System.out.println(1);
    }
}