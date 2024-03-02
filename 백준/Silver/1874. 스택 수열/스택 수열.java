import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] wish = new int[n];
        for (int i = 0; i < n; i++) {
            wish[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        int i = 1, index = 0;

        while (index < n) {
            if (stack.isEmpty()) {
                stack.add(i++);
                sb.append("+\n");
            }
            int p = stack.peek();
            if (p == wish[index]) {
                stack.pop();
                sb.append("-\n");
                index++;
            } else {
                if (i > n) {
                    System.out.println("NO");
                    return;
                }
                stack.add(i++);
                sb.append("+\n");
            }
        }
        System.out.println(sb.toString());
    }
}