import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int t1 = Math.abs(o1);
            int t2 = Math.abs(o2);
            if (t1 != t2)
                return Integer.compare(t1, t2);
            else
                return Integer.compare(o1, o2);
        });
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0)
                pq.offer(input);
            else {
                sb.append(pq.isEmpty() ? 0 : pq.poll());
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
