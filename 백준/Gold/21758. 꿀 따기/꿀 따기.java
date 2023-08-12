import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, max;
    static int[] flower;
    static int[] pickIdx;
    static boolean[] visit;
    static int[] dy = {-1, 1};  // 왼, 오

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        flower = new int[N];
        max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            flower[i] = Integer.parseInt(st.nextToken());
        }

        // 꿀통 설정
        for (int i = 0; i < N; i++) {
            pickIdx = new int[2];
            visit = new boolean[N];
            visit[i] = true;
            comb(0, 0, i);
        }

        System.out.println(max);
    }

    private static void comb(int start, int cnt, int honeyIdx) {
        if (cnt == 2) {
            int sum = 0;

            int com = pickIdx[1];
            for (int k = 0; k < pickIdx.length; k++) {
                int p = pickIdx[k];

                if (p > honeyIdx) {
                    // 왼쪽으로 이동
                    for (int i = p - 1; i >= honeyIdx; i--) {
                        if (com != i)
                            sum += flower[i];
                    }
                } else {
                    // 오른쪽으로 이동
                    for (int i = p + 1; i <= honeyIdx; i++) {
                        if (com != i)
                            sum += flower[i];
                    }
                }
                com = p;
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = start; i < N; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            pickIdx[cnt] = i;
            comb(i + 1, cnt + 1, honeyIdx);
            visit[i] = false;
        }
    }
}