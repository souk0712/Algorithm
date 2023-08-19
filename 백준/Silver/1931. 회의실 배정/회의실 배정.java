import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static PriorityQueue<Schedule> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new Schedule(start, end));
        }

        int ans = 1;
        Schedule cur = pq.poll();

        while (!pq.isEmpty()) {
            Schedule next = pq.poll();
            if (cur.end <= next.start){
                ans++;
                cur = next;
            }
        }

        System.out.println(ans);
    }

    public static class Schedule implements Comparable<Schedule> {
        int start, end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Schedule o) {
            if (this.end == o.end)
                return Integer.compare(this.start, o.start);
            else
                return Integer.compare(this.end, o.end);
        }
    }
}