import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static University[] universities;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        universities = new University[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            String gender = st.nextToken();
            if ("M".equals(gender)) {
                universities[i] = new University(i, 0, i);
            } else if ("W".equals(gender)) {
                universities[i] = new University(i, 1, i);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(u, v, d));
        }

        int ans = kruskal(pq);
        System.out.println(isCheckAllPath() ? ans : -1);
    }

    private static boolean isCheckAllPath() {
        int compareParent = find(universities[1].parent);
        for (int i = 2; i < universities.length; i++) {
            int universityParent = find(universities[i].parent);
            if (compareParent != universityParent) {
                return false;
            }
        }
        return true;
    }

    private static int kruskal(PriorityQueue<Edge> pq) {
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (universities[cur.v].gender == universities[cur.u].gender) continue;
            if (find(cur.u) == find(cur.v)) continue;
            union(cur.u, cur.v);
            sum += cur.d;
        }
        return sum;
    }

    public static void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa == bb) return;
        if (aa < bb) universities[bb].parent = aa;
        else universities[aa].parent = bb;
    }

    public static int find(int x) {
        if (universities[x].parent == x) return x;
        return universities[x].parent = find(universities[x].parent);
    }

    public static class University {
        int index, gender, parent;  // 0:M, 1:W

        University(int index, int gender, int parent) {
            this.index = index;
            this.gender = gender;
            this.parent = parent;
        }
    }

    public static class Edge implements Comparable<Edge> {
        int u, v, d;

        Edge(int u, int v, int d) {
            this.u = u;
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(d, o.d);
        }
    }
}