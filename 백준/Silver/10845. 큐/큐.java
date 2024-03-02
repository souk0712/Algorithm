import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (q.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(q.pollFirst());
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if (q.isEmpty())
                        sb.append(1);
                    else
                        sb.append(0);
                    sb.append("\n");
                    break;
                case "front":
                    if (q.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(q.peekFirst());
                    sb.append("\n");
                    break;
                case "back":
                    if (q.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(q.peekLast());
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}