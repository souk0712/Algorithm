import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int k, m, p;
    static ArrayList<Integer>[] list;
    static int[] in;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            list = new ArrayList[m + 1];
            in = new int[m + 1];
            for (int i = 1; i < list.length; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                in[b]++;
            }

            sb.append(k).append(" ").append(topologySort()).append("\n");
        }
        System.out.println(sb);
    }

    private static int topologySort() {
        Queue<River> q = new LinkedList<>();
        River[] rivers = new River[m + 1];
        for (int i = 1; i < in.length; i++) {
            rivers[i] = new River(i);
            if (in[i] == 0) {
                rivers[i].strahler = 1;
                q.offer(rivers[i]);
            }
        }
        int max = 0;
        while (!q.isEmpty()) {
            River cur = q.poll();
            max = Math.max(max, cur.strahler);
            for (int k = 0; k < list[cur.index].size(); k++) {
                int next = list[cur.index].get(k);
                rivers[next].inputStrahler(cur.strahler);
                if (--in[next] == 0) {
                    q.offer(rivers[next]);
                }
            }
        }
        return max;
    }

    static class River {
        int index, strahler, max;
        Set<Integer> inStrahler;

        River(int index) {
            this.index = index;
            this.strahler = -1;
            this.max = -1;
            this.inStrahler = new HashSet<>();
        }

        public void inputStrahler(int strahler) {
            if (max <= strahler) {
                max = strahler;
                if (inStrahler.contains(strahler)) {
                    this.strahler = strahler + 1;
                } else {
                    inStrahler.add(strahler);
                    this.strahler = strahler;
                }
            }
        }
    }
}