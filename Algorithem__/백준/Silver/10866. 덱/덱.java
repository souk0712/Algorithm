import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num = 0;
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }
            deque(dq, sb, str, num);
        }
        System.out.println(sb);
    }

    private static void deque(Deque<Integer> dq, StringBuilder sb, String str, int num) {
        switch (str) {
            case "push_front":
                dq.addFirst(num);
                break;
            case "push_back":
                dq.addLast(num);
                break;
            case "pop_front":
                if (dq.isEmpty()) {
                    sb.append(-1).append("\n");
                    break;
                }
                sb.append(dq.pollFirst()).append("\n");
                break;
            case "pop_back":
                if (dq.isEmpty()) {
                    sb.append(-1).append("\n");
                    break;
                }
                sb.append(dq.pollLast()).append("\n");
                break;
            case "size":
                sb.append(dq.size()).append("\n");
                break;
            case "empty":
                if (dq.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
                break;
            case "front":
                if (dq.isEmpty()) {
                    sb.append(-1).append("\n");
                    break;
                }
                sb.append(dq.peekFirst()).append("\n");
                break;
            case "back":
                if (dq.isEmpty()) {
                    sb.append(-1).append("\n");
                    break;
                }
                sb.append(dq.peekLast()).append("\n");
                break;
        }
    }
}