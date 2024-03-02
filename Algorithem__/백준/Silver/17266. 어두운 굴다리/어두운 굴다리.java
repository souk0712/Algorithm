import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, min;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 굴다리의 길이
        M = Integer.parseInt(br.readLine());    // 가로등의 개수
        arr = new int[M];                       // 가로등의 위치
        min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        System.out.println(height());
    }

    private static int height() {
        int max = Math.max(arr[0], Math.abs(arr[arr.length - 1] - N));

        for (int i = 0; i < arr.length - 1; i++) {
            double A = arr[i];
            double B = arr[i + 1];
            int diff = (int) Math.round(Math.abs(B - A) / 2);

            max = Math.max(diff, max);
        }

        return max;
    }
}