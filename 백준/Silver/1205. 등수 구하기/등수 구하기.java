import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> scores = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(sc.next());
            scores.offer(input);
        }

        scores.offer(newScore);

        int index = 1, rank = 1, ans = 0;

        while (!scores.isEmpty()) {
            int score = scores.poll();
            if (score == newScore) {
                if (index <= P) {
                    ans = rank;
                } else {
                    ans = -1;
                }
            } else {
                if (ans == 0)
                    rank++;
                else
                    rank += 2;
            }
            index++;
        }
        System.out.println(ans);
    }
}