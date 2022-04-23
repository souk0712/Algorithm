import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Java10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.valueOf(st.nextToken()));
                    break;
                case "pop":
                    if (stack.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "top":
                    if (stack.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(stack.peek());
                    break;
            }
        }

    }
}
