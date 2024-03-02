import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N, K, state;
    static int[] belt;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[N * 2];
        visit = new boolean[2 * N];
        state = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        // 4. 내구도 0이 K개 이상시 종료
        while (state < K) {
            count++;
            // 1. 벨트 이동(로봇들도 같이 이동)
            belt = moveBelt();
            // 2. 로봇 이동 (앞에 로봇이 없어야 하고, 내구도 >=1), (이동하는 자리 내구도 -1)
            moveRobot();
            // 3. 올리는 위치 내구도 !=0면 로봇 올림(올리는 자리 내구도 -1)
            putRobot();
        }

        System.out.println(count);
    }

    private static void putRobot() {
        if (belt[0] != 0) {
            visit[0] = true;
            if (--belt[0] == 0) state++;
        }
    }

    private static void moveRobot() {
        for (int i = N - 1; i >= 0; i--) {
            if (!visit[i]) continue;
            int next = i + 1;
            if (visit[next] || belt[next] <= 0) continue;
            visit[i] = false;
            if (next == N - 1) {
                if (--belt[next] == 0) state++;
                continue;
            }
            visit[next] = true;
            if (--belt[next] == 0) state++;
        }
    }

    private static int[] moveBelt() {
        int[] res = new int[2 * N];
        for (int i = 0; i < belt.length; i++) {
            res[(i + 1) % (2 * N)] = belt[i];
        }

        for (int i = N - 1; i >= 0; i--) {
            if (!visit[i]) continue;
            int pos = i + 1;
            visit[i] = false;
            if (pos != N - 1) {
                visit[pos] = true;
            }
        }
        return res;
    }
}