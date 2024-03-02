package UTC;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class UTC02_comparable {
    public static void main(String[] args) throws IOException {
        int[][] a = {{85, 90}, {91, 87}, {88, 87}};
        int[][] input = {{85, 90}, {65, 67}, {88, 87}, {88, 87}, {73, 81}, {65, 89}, {99, 100}, {80, 94}};

        int[] answer = solution(input);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static int[] problemTotal;

    public static int[] solution(int[][] scores) {
        problemTotal = new int[2];
        for (int i = 0; i < scores.length; i++) {
            problemTotal[0] += scores[i][0];
            problemTotal[1] += scores[i][1];
        }

        int[] answer = new int[scores.length];

        PriorityQueue<User> pq = new PriorityQueue<>();

        for (int i = 0; i < scores.length; i++) {
            int firstScore = scores[i][0];
            int secondScore = scores[i][1];
            int total = firstScore + secondScore;
            pq.offer(new User(i, firstScore, secondScore, total));
        }

        int size = pq.size();
        for (int i = 0; i < size; i++) {
            User user = pq.poll();
            answer[user.id] = i + 1;
        }
        return answer;
    }

    public static class User implements Comparable<User>{
        public int id;
        public int firstScore;
        public int secondScore;
        public int total;

        public User(int id, int firstScore, int secondScore,
                    int total
        ) {
            this.id = id;
            this.firstScore = firstScore;
            this.secondScore = secondScore;
            this.total = total;
        }

        @Override
        public int compareTo(User o) {
            if (this.total != o.total)
                return Integer.compare(o.total, this.total);

            if (problemTotal[0] > problemTotal[1]) {
                if (o.secondScore == this.secondScore)
                    return Integer.compare(this.id, o.id);
                return Integer.compare(o.secondScore, this.secondScore);

            } else if (problemTotal[0] < problemTotal[1]) {
                if (o.firstScore == this.firstScore)
                    return Integer.compare(this.id, o.id);
                return Integer.compare(o.firstScore, this.firstScore);
            }
            return Integer.compare(this.id, o.id);
        }
    }
}
