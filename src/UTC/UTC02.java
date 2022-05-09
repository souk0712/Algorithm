package UTC;

import java.io.IOException;

public class UTC02 {
    public static void main(String[] args) throws IOException {
        int[][] a = {{85, 90}, {91, 87}, {88, 87}};
        int[][] input = {{85, 90}, {65, 67}, {88, 87}, {88, 87}, {73, 81}, {65, 89}, {99, 100}, {80, 94}};

        int[] answer = solution(input);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]+" ");
        }
    }

    public static int[] solution(int[][] scores) {
        int first = 0;
        int second = 0;
        int size = scores.length;
        int[][] map = new int[size][5];
        boolean[] checked = new boolean[size];
        for (int i = 0; i < size; i++) {
            map[i][0] = i + 1;
            for (int j = 1; j <= 2; j++) {
                map[i][j] = scores[i][j - 1];
            }
            map[i][3] = scores[i][0] + scores[i][1];
            first += scores[i][0];
            second += scores[i][1];
        }

        int grade = 1;
        for (int j = 0; j < size; j++) {
            int[] max = new int[2];
            for (int i = 0; i < size; i++) {
                if (!checked[i]) {
                    if (max[1] < map[i][3]) {
                        max[0] = map[i][0];
                        max[1] = map[i][3];
                    } else if (max[1] == map[i][3]) {
                        if (first < second) {
                            if (map[max[0] - 1][1] < map[i][1]) {
                                max[0] = map[i][0];
                                max[1] = map[i][3];
                            }

                        } else if (first == second) {
                            if (max[0] > map[i][0]) {
                                max[0] = map[i][0];
                                max[1] = map[i][3];
                            }

                        } else {
                            if (map[max[0] - 1][2] < map[i][2]) {
                                max[0] = map[i][0];
                                max[1] = map[i][3];
                            }
                        }
                    }
                }
            }
            if (!checked[max[0] - 1]) {
                map[max[0] - 1][4] = grade++;
                checked[max[0] - 1] = true;
            }
        }
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = map[i][4];
        }
        return answer;
    }
}
