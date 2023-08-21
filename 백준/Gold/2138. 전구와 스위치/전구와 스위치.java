import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, min;
    static int[] init, finish;
    static int[] dy = {0, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        init = new int[N];
        finish = new int[N];
        
        String input = br.readLine();
        for (int i = 0; i < N; i++) {
            init[i] = input.charAt(i) - '0';
        }

        input = br.readLine();
        for (int i = 0; i < N; i++) {
            finish[i] = input.charAt(i) - '0';
        }

        int[] temp = copyArr();

        // 0, 1번이 바뀌지 않을 때(-1번째 스위치 누르지 않을 때)
        clickSwitch(temp, 0, 0);

        temp = copyArr();
        // 0, 1번이 바뀔 때(-1번째 스위치 누를 때)
        for (int i = 0; i < 2; i++) {
            if (temp[i] == 1) {
                temp[i] = 0;
            } else {
                temp[i] = 1;
            }
        }

        clickSwitch(temp, 0, 1);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void clickSwitch(int[] arr, int i, int cnt) {
        if (i == N - 1) {
            if (check(arr))
                min = Math.min(min, cnt);
            return;
        }

        // 같을 때
        if (arr[i] != finish[i]) {
            // 버튼 누름으로 변화
            for (int k = 0; k < dy.length; k++) {
                int pos = i + dy[k];
                if (pos >= N) continue;

                if (arr[pos] == 1)
                    arr[pos] = 0;
                else
                    arr[pos] = 1;

            }
            clickSwitch(arr, i + 1, cnt + 1);
        } else {    // 다를 때
            clickSwitch(arr, i + 1, cnt);
        }
    }

    private static boolean check(int[] arr) {
        for (int i = 0; i < N; i++) {
            if (arr[i] != finish[i]) return false;
        }
        return true;
    }

    private static int[] copyArr() {
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = init[i];
        }
        return temp;
    }
}