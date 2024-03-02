import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] attack = new int[N];
        int[] evasion = new int[N];
        float[] change = new float[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            attack[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            evasion[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            change[i] = Float.parseFloat(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int a = (int) (attack[i] * (change[i] * 10) / 10);
            int e = (int) (evasion[i] * (change[i] * 10) / 10);
            if (change[i] < 1) {
                sum += attack[i];
                sum -= e;
            } else {
                sum += a;
                sum -= evasion[i];
            }
        }
        System.out.println(sum);
    }
}