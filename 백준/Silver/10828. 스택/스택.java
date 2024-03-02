import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    stack.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (stack.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(stack.pop());
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if (stack.isEmpty())
                        sb.append(1);
                    else
                        sb.append(0);
                    sb.append("\n");
                    break;
                case "top":
                    if (stack.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(stack.peek());
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}