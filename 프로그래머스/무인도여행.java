import java.util.*;

public class 무인도여행 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int M;

    public static void main(String[] args) {
        String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};
        int[] res = solution(maps);
        System.out.println(Arrays.toString(res));
    }

    public static int[] solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = maps[i].toCharArray();
        }
        boolean[][] visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 'X' && !visit[i][j]) {
                    int res = bfs(map, visit, i, j);
                    answer.add(res);
                }
            }
        }
        answer.sort(Comparator.comparingInt(a -> a));
        if (answer.size() == 0)
            return new int[]{-1};

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static int bfs(char[][] map, boolean[][] visit, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        int sum = 0;
        q.add(new int[]{i, j});
        visit[i][j] = true;
        while (!q.isEmpty()) {
            int[] value = q.poll();
            int x = value[0];
            int y = value[1];
            sum += map[x][y] - '0';
            for (int k = 0; k < dx.length; k++) {
                int ii = x + dx[k];
                int jj = y + dy[k];
                if (ii < 0 || jj < 0 || ii >= N || jj >= M) continue;
                if (map[ii][jj] == 'X') continue;
                if (!visit[ii][jj]) {
                    visit[ii][jj] = true;
                    q.offer(new int[]{ii, jj});
                }
            }
        }
        return sum;
    }
}
