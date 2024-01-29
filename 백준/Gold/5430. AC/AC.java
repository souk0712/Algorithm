import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        loop:
        for (int t = 0; t < T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[|],");
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                dq.offer(num);
            }
            boolean isFront = true;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'D') {
                    if (!dq.isEmpty()) {
                        if (isFront) {
                            dq.pollFirst();
                        } else {
                            dq.pollLast();
                        }
                    } else {
                        sb.append("error").append("\n");
                        continue loop;
                    }
                } else if (p.charAt(i) == 'R') {
                    isFront = !isFront;
                }
            }
            sb.append("[");
            while (!dq.isEmpty()) {
                int ans;
                if (isFront) {
                    ans = dq.pollFirst();
                } else {
                    ans = dq.pollLast();
                }
                sb.append(ans);
                if (!dq.isEmpty()) {
                    sb.append(",");
                }
            }
            sb.append("]").append("\n");
        }
        System.out.println(sb);
    }
}