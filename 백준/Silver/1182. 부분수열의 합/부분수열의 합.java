import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, S, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        arr = new int[N];
        String[] arrInput = br.readLine().split(" ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(arrInput[i]);
        }

        ans = 0;
        sumFunction(0, 0);
        System.out.println(ans);
    }

    private static void sumFunction(int flag, int cnt) {
        if (cnt == N) {
            // 공집합인 경우
            if (flag == 0) return;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                // i번째 비트가 1이라면 arr[i]값을 sum에 더하기
                if (((1 << i) & flag) > 0) {
                    sum += arr[i];
                }
            }
            // 합이 S가 된다면 개수 추가
            if (sum == S) {
                ans++;
            }

            return;
        }
        // cnt번째 비트를 선택하지 않는 경우
        sumFunction(flag, cnt + 1);

        // cnt번째 비트를 선택한 경우
        flag = (1 << cnt) | flag;
        sumFunction(flag, cnt + 1);
    }
}