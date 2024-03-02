import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, min;
    static int[][] map;
    static int[] start, link;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        map = new int[N + 1][N + 1];
        start = new int[N / 2];
        link = new int[N / 2];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pickStart(1, 0);

        System.out.println(min);
    }

    // start 팀 배정
    private static void pickStart(int st, int cnt) {
        if (cnt == N / 2) {
            for (int j = 1, index = 0; j < visit.length; j++) {
                // link 팀 배정
                if (visit[j]) continue;
                link[index++] = j;
            }
            calculateScore();
            return;
        }

        for (int i = st; i <= N; i++) {
            visit[i] = true;
            start[cnt] = i;
            pickStart(i + 1, cnt + 1);
            visit[i] = false;
        }
    }

    // 팀 배정대로 점수 계산
    private static void calculateScore() {

        // 1 2 3    //4 5 6
        // 12,13,23,21,31,32
        int scoreS = 0;
        //start팀 점수 계산
        for (int i = 0; i < start.length; i++) {
            for (int j = i + 1; j < start.length; j++) {
                scoreS += map[start[i]][start[j]];
                scoreS += map[start[j]][start[i]];
            }
        }

        int scoreL = 0;
        //link팀 점수 계산
        for (int i = 0; i < link.length; i++) {
            for (int j = i + 1; j < link.length; j++) {
                scoreL += map[link[i]][link[j]];
                scoreL += map[link[j]][link[i]];
            }
        }

        min = Math.min(min, Math.abs(scoreL - scoreS));
    }
}