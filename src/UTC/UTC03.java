package UTC;

public class UTC03 {
    public static void main(String[] args) {
        String[] input = {"ABBBBC", "AABAAC", "BCDDAC", "DCCDDE", "DCCEDE", "DDEEEB"};
        String[] a = {"DDCCC", "DBBBC", "DBABC", "DBBBC", "DDCCC"};

        int answer = solution(a);
        System.out.print(answer);
    }

    public static int solution(String[] board) {
        int answer = 0;
        int N = board.length;
        String[][] map = new String[N][N];

        for (int i = 0; i < map.length; i++) {
            map[i] = board[i].split("");
        }
        int[][] count = new int[2][N];
        for (int i = 0; i < N; i++) {
            boolean[][] visited = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                int rc = 0;
                int countNum = i;
                dfs(N, map, rc, countNum, i, j, count, visited);
            }
        }
        for (int j = 0; j < N; j++) {
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                int rc = 1;
                int countNum = j;
                dfs(N, map, rc, countNum, i, j, count, visited);
            }
        }

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[0].length; j++) {
                if (answer < count[i][j]) {
                    answer = count[i][j];
                }
            }
        }
        return answer;
    }

    public static void dfs(int N, String[][] map, int rc, int countNum, int i, int j, int[][] count, boolean[][] visited) {
        if (visited[i][j]) return;
        visited[i][j] = true;
        count[rc][countNum]++;
        int[][] pos = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int k = 0; k < 4; k++) {
            int x = i + pos[k][0];
            int y = j + pos[k][1];

            if (x < 0 || x >= N || y < 0 || y >= N) continue;
            if (visited[x][y]) continue;
            if (!map[i][j].equals(map[x][y])) continue;

            dfs(N, map, rc, countNum, x, y, count, visited);

        }
    }
}
