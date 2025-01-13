import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};    // 시계방향(우, 하, 좌, 상)
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 패널의 점수 계산
        int[][] scorePanel = calculateScoreForEachPanel();

        // 횟수만큼 이동
        System.out.println(moveDice(scorePanel));
    }

    private static int[][] calculateScoreForEachPanel() {
        int[][] scorePanel = new int[N][M];
        boolean[][] visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) continue;
                visit[i][j] = true;
                bfs(i, j, scorePanel, visit);
            }
        }
        return scorePanel;
    }

    private static void bfs(int i, int j, int[][] score, boolean[][] visit) {
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        q.offer(new int[]{i, j});
        ArrayList<int[]> routes = new ArrayList<>();
        routes.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            cnt++;
            for (int k = 0; k < 4; k++) {
                int mx = cur[0] + dx[k];
                int my = cur[1] + dy[k];
                if (checkRangeOut(mx, my)) continue;
                if (visit[mx][my] || map[mx][my] != map[cur[0]][cur[1]]) continue;
                visit[mx][my] = true;
                q.offer(new int[]{mx, my});
                routes.add(new int[]{mx, my});
            }
        }
        for (int[] route : routes) {
            score[route[0]][route[1]] = map[i][j] * cnt;
        }
    }

    private static boolean checkRangeOut(int mx, int my) {
        return mx < 0 || my < 0 || mx >= N || my >= M;
    }

    private static int moveDice(int[][] scorePanel) {
        int curX = 0, curY = 0, dir = 0;
        int score = 0;
        int[][] dice = new int[][]{{0, 2, 0}, {4, 1, 3}, {0, 5, 0}, {0, 6, 0}};

        for (int i = 0; i < K; i++) {
            int nx = curX + dx[dir];
            int ny = curY + dy[dir];

            // 만약, 이동 방향에 칸이 없다면, 이동 방향을 반대로 한 다음 한 칸 굴러간다.
            if (checkRangeOut(nx, ny)) {
                dir = (dir + 2) % 4;
                nx = curX + dx[dir];
                ny = curY + dy[dir];
            }
            curX = nx;
            curY = ny;
            // 주사위 굴리기
            dice = rollDice(dir, dice);
            // 점수 획득
            score += scorePanel[curX][curY];
            // 방향 정하기
            dir = setDirection(dir, dice, curX, curY);
        }
        return score;
    }

    private static int setDirection(int dir, int[][] dice, int curX, int curY) {
        int A = dice[3][1];
        int B = map[curX][curY];
        if (A > B) {
            dir = (dir + 1) % 4;
        } else if (A < B) {
            dir = (dir + 3) % 4;
        }

        return dir;
    }

    private static int[][] rollDice(int dir, int[][] dice) {
        int[][] newDice = copyDice(dice);
        if (dir == 0) {
            newDice[1][1] = dice[1][0];
            newDice[1][0] = dice[3][1];
            newDice[1][2] = dice[1][1];
            newDice[3][1] = dice[1][2];
        } else if (dir == 1) {
            newDice[1][1] = dice[0][1];
            newDice[0][1] = dice[3][1];
            newDice[2][1] = dice[1][1];
            newDice[3][1] = dice[2][1];
        } else if (dir == 2) {
            newDice[1][1] = dice[1][2];
            newDice[1][0] = dice[1][1];
            newDice[1][2] = dice[3][1];
            newDice[3][1] = dice[1][0];
        } else if (dir == 3) {
            newDice[1][1] = dice[2][1];
            newDice[0][1] = dice[1][1];
            newDice[2][1] = dice[3][1];
            newDice[3][1] = dice[0][1];
        }
        return newDice;
    }

    private static int[][] copyDice(int[][] dice) {
        int[][] newDice = new int[4][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                newDice[i][j] = dice[i][j];
            }
        }
        return newDice;
    }
}