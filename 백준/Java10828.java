package week2;

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

/**
 * Stack : 차곡차곡 하나씩 데이터가 스택 자료구조에 쌓임
 * stack.push("Data"); : 스택에 데이터 추가
 * stack.pop() : 스택으로부터 맨위의 값을 꺼냄
 * stack.peek() : 스택에서 최상단 값을 확인
 * stack.empty() : 스택이 비어있는지 여부를 판단. 데이터가 있으면 false, 없으면 true 반환.
 * stack.contains() : 스택에 특정 데이터가 포함되어 있는지 체크.
 * stack.clear() : 스택에 있는 모든 데이터를 한번에 날림.
 * stack.size() : 스택에 들어있는 데이터의 개수 리턴
 */