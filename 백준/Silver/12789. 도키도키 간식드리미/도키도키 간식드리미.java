import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        int next = 1, index = 0;
        while (next <= N) {
            if (index < N && next == arr[index]) {
                next++;
                index++;
            } else {
                if (!stack.isEmpty() && stack.peek() == next) {
                    stack.pop();
                    next++;
                } else if (index < N) {
                    stack.push(arr[index]);
                    index++;
                } else {
                    break;
                }
            }
        }
        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }
}