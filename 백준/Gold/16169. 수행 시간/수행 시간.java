import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[] grade, running, in;
    static Map<Integer, ArrayList<Integer>> indexByGrade;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        indexByGrade = new HashMap<>();
        running = new int[n + 1];
        in = new int[n + 1];
        grade = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            grade[i] = Integer.parseInt(st.nextToken());
            ArrayList<Integer> indexList;
            if (indexByGrade.containsKey(grade[i])) {
                indexList = indexByGrade.get(grade[i]);
            } else {
                indexList = new ArrayList<>();
            }
            indexList.add(i);
            indexByGrade.put(grade[i], indexList);
            running[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            if (indexByGrade.containsKey(grade[i] + 1)) {
                for (int j = 0; j < indexByGrade.get(grade[i] + 1).size(); j++) {
                    int idx = indexByGrade.get(grade[i] + 1).get(j);
                    list[i].add(idx);
                    in[idx]++;
                }
            }
        }
        System.out.println(topologySort());
    }

    private static int topologySort() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        int[] time = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            time[i] = running[i];
            if (in[i] == 0) {
                pq.offer(new int[]{i, running[i]});
            }
        }
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            res = Math.max(res, cur[1]);

            for (int k = 0; k < list[cur[0]].size(); k++) {
                int next = list[cur[0]].get(k);
                int spendTime = (next - cur[0]) * (next - cur[0]);
                time[next] = Math.max(time[next], cur[1] + spendTime + running[next]);
                if (--in[next] == 0) {
                    pq.offer(new int[]{next, time[next]});
                }
            }
        }
        return res;
    }
}