package UTC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class UTC02_pq {
    public static void main(String[] args) throws IOException {
        int[][] a = {{85, 90}, {91, 87}, {88, 87}};
        int[][] input = {{85, 90}, {65, 67}, {88, 87}, {88, 87}, {73, 81}, {65, 89}, {99, 100}, {80, 94}};

        int[] answer = solution(input);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static int[] solution(int[][] scores) {
        int[] problemTotal = new int[2];
        for (int i = 0; i < scores.length; i++) {
            problemTotal[0] += scores[i][0];
            problemTotal[1] += scores[i][1];
        }

        int[] answer = new int[scores.length];
        Comparator<User> cp = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.total != o2.total)
                    return Integer.compare(o2.total, o1.total);

                if (problemTotal[0] > problemTotal[1]) {
                    if (o2.secondScore == o1.secondScore)
                        return Integer.compare(o1.id, o2.id);
                    return Integer.compare(o2.secondScore, o1.secondScore);

                } else if (problemTotal[0] < problemTotal[1]) {
                    if (o2.firstScore == o1.firstScore)
                        return Integer.compare(o1.id, o2.id);
                    return Integer.compare(o2.firstScore, o1.firstScore);
                }
                return Integer.compare(o1.id, o2.id);
            }
        };

        PriorityQueue<User> pq = new PriorityQueue<>(cp);

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

    public static class User {
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
    }
}
