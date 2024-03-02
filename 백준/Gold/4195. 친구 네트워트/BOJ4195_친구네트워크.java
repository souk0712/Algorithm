import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ4195_친구네트워크 {

    static Map<String, Integer> table;
    static int[] union;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int F = Integer.parseInt(br.readLine());

            table = new HashMap<>();
            union = new int[F * 2 + 1];
            count = new int[F * 2 + 1];
            for (int i = 1; i < union.length; i++) union[i] = i;

            int root, index = 1;

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String from = st.nextToken();
                String to = st.nextToken();


                if (!table.containsKey(from)) {
                    table.put(from, index);
                    count[index] = 1;
                    index++;
                }

                if (!table.containsKey(to)) {
                    table.put(to, index);
                    count[index] = 1;
                    index++;
                }

                int fromIdx = table.get(from);
                int toIdx = table.get(to);

                Union(fromIdx, toIdx);

                root = Find(fromIdx);

                sb.append(count[root]).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void Union(int x, int y) {
        int a = Find(x);
        int b = Find(y);
        if (a == b) return;

        if (a > b) {
            union[a] = b;
            count[b] += count[a];
        } else {
            union[b] = a;
            count[a] += count[b];
        }
    }

    private static int Find(int x) {
        if (union[x] == x) return x;
        return union[x] = Find(union[x]);
    }
}