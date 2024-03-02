import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] union;
    static int[] money;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        union = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            union[i] = i;
        }

        String[] moneys = br.readLine().split(" ");
        money = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            money[i] = Integer.parseInt(moneys[i - 1]);
        }

        for (int i = 0; i < M; i++) {
            String[] connect = br.readLine().split(" ");
            int v = Integer.parseInt(connect[0]);
            int w = Integer.parseInt(connect[1]);

            Union(v, w);
        }

        int sum = 0;
        
        for (int i = 1; i <= N; i++) {
            if (union[i] == i) {
                sum += money[i];
            }
        }

        if (sum <= K) System.out.println(sum);
        else System.out.println("Oh no");
    }

    private static void Union(int x, int y) {
        int a = Find(x);
        int b = Find(y);
        if (a == b) return;
        if (money[a] > money[b]) {
            union[a] = b;
        } else {
            union[b] = a;
        }
    }

    private static int Find(int x) {
        if (x == union[x]) return x;
        return union[x] = Find(union[x]);
    }
}