import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, LIMIT;
    static String king;
    static Map<String, Integer> nameToIndex;
    static Map<Integer, String> indexToName;
    static int[] in;
    static double[] value;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        LIMIT = n * 3;
        king = br.readLine();
        nameToIndex = new HashMap<>();
        indexToName = new HashMap<>();
        in = new int[LIMIT];
        value = new double[LIMIT];
        list = new ArrayList[LIMIT];
        for (int i = 0; i < LIMIT; i++) {
            list[i] = new ArrayList<>();
        }
        nameToIndex.put(king, 0);
        indexToName.put(0, king);
        int idx = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String p1 = st.nextToken();
            String p2 = st.nextToken();

            if (!nameToIndex.containsKey(p1)) {
                indexToName.put(idx, p1);
                nameToIndex.put(p1, idx++);
            }
            if (!nameToIndex.containsKey(p2)) {
                indexToName.put(idx, p2);
                nameToIndex.put(p2, idx++);
            }
            if (!nameToIndex.containsKey(child)) {
                indexToName.put(idx, child);
                nameToIndex.put(child, idx++);
            }
            int childIndex = nameToIndex.get(child);
            int p1Index = nameToIndex.get(p1);
            int p2Index = nameToIndex.get(p2);
            list[p1Index].add(childIndex);
            list[p2Index].add(childIndex);
            in[childIndex] = 2;
        }

        value[0] = 1;
        topologySort();

        String ans = "";
        double ansValue = 0;

        for (int i = 0; i < m; i++) {
            String nextKing = br.readLine();
            if (nameToIndex.containsKey(nextKing) && ansValue < value[nameToIndex.get(nextKing)]) {
                ansValue = value[nameToIndex.get(nextKing)];
                ans = nextKing;
            }
        }
        System.out.println(ans);
    }

    private static void topologySort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < LIMIT; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (!nameToIndex.containsKey(indexToName.get(cur))) continue;
            for (int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i);
                value[next] += value[cur] / 2;
                if (--in[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}