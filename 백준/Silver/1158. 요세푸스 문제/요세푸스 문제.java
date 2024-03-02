import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);

        // 0 1 2 3 4 5 6 7
        sb.append("<");
        int index = K - 1;
        while (list.size() > 0) {
            int res = list.remove(index %= list.size()) + 1;
            index += K - 1;
            sb.append(res);
            if (list.size() != 0) sb.append(", ");
        }
        sb.append(">");

        System.out.println(sb);
    }
}