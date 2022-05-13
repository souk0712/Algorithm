package UTC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class UTC02_sort {
    public static void main(String[] args) throws IOException {
        int[][] a = {{85, 90}, {91, 87}, {88, 87}};
        int[][] input = {{85, 90}, {65, 67}, {88, 87}, {88, 87}, {73, 81}, {65, 89}, {99, 100}, {80, 94}};

        int[] answer = solution(input);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static int[] solution(int[][] scores) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            int firstScore = scores[i][0];
            int secondScore = scores[i][1];
            int total = firstScore + secondScore;
            userList.add(new User(i, firstScore, secondScore, total, 0));
        }
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

        userList.sort(cp);
        for (int i = 0; i < userList.size(); i++) {
            userList.get(i).rankSetter(i + 1);
        }

        for (int i = 0; i < userList.size(); i++) {
            for (int j = 0; j < userList.size(); j++) {
                if (userList.get(i).id == j)
                    answer[j] = userList.get(i).rank;
            }
        }
        return answer;
    }

    public static class User {
        public int id;
        public int firstScore;
        public int secondScore;
        public int total;
        public int rank;

        public User(int id, int firstScore, int secondScore,
                    int total, int rank
        ) {
            this.id = id;
            this.firstScore = firstScore;
            this.secondScore = secondScore;
            this.rank = rank;
            this.total = total;
        }

        public void rankSetter(int rank) {
            this.rank = rank;
        }
    }
}
