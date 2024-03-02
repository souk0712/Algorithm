import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            left.push(input.charAt(i));
        }

        for (int i = 0; i < list.size(); i++) {
            char commend = list.get(i).charAt(0);
            switch (commend) {
                case 'L':
                    if (!left.isEmpty()) {
                        char c = left.pop();
                        right.push(c);
                    }
                    break;
                case 'D':
                    if (!right.isEmpty()) {
                        char c = right.pop();
                        left.push(c);
                    }
                    break;
                case 'B':
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case 'P':
                    char ins = list.get(i).charAt(2);
                    left.push(ins);
                    break;
            }
        }

        for (char c : left) {
            sb.append(c);
        }

        Collections.reverse(right);
        for (char c : right) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}