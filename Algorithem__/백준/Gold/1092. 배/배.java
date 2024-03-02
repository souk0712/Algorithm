import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer> crane, weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        crane = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(st.nextToken());
            crane.add(c);
        }

        M = Integer.parseInt(br.readLine());
        weight = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int w = Integer.parseInt(st.nextToken());
            weight.add(w);
        }

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(weight, Collections.reverseOrder());

        if (crane.get(0) < weight.get(0)) {
            System.out.println(-1);
            return;
        }

        int sec = 0;
        while (!weight.isEmpty()) {
            int wIdx = 0;
            int cIdx = 0;

            while (cIdx < N && wIdx < weight.size()) {
                if (crane.get(cIdx) >= weight.get(wIdx)) {
                    weight.remove(wIdx);
                    cIdx++;
                } else wIdx++;
            }
            sec++;
        }

        System.out.println(sec);
    }
}