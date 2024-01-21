import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static Stone[] stones;
    static int[] bag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stones = new Stone[N];
        bag = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            stones[i] = new Stone(m, v);
        }

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(stones, (o1, o2) -> Integer.compare(o1.m, o2.m));
        Arrays.sort(bag);

        int stoneIndex = 0;
        long sum = 0;
        PriorityQueue<Stone> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.v, o1.v));
        for (int i = 0; i < K; i++) {
            while (stoneIndex < N && stones[stoneIndex].m <= bag[i]) {
                Stone current = stones[stoneIndex++];
                pq.offer(current);
            }
            if (!pq.isEmpty()) {
                sum += pq.poll().v;
            }
        }
        System.out.println(sum);
    }

    static class Stone {
        int m, v;

        Stone(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}