import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // k 거쳐가는 노드
        for (int k = 0; k < N; k++) {
            // i 출발 노드
            for (int i = 0; i < N; i++) {
                // j 도착 노드
                for (int j = 0; j < N; j++) {
                    // (i, k) -> (k, j) -> (k, i) 방향 그래프에서 다른 간선과 노드를 통해 해당 노드로 이동이 가능한가를 판별
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}