import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Java10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Deque<Integer> queue = new LinkedList();

        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();
            StringTokenizer st = new StringTokenizer(input);
            switch (st.nextToken()) {
                case "push":
                    queue.offer(Integer.valueOf(st.nextToken()));
                    break;
                case "pop":
                    if (queue.isEmpty())
                        System.out.println(-1);
                    else
                    System.out.println(queue.poll());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if (queue.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "front":
                    if (queue.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(queue.peekFirst());
                    break;
                case "back":
                    if (queue.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(queue.peekLast());
                    break;

            }
        }

    }
}

/**
 * 큐는 기본 원칙이 '선입선출(FIFO : First in First out)' 이다.
 * 먼저 들어온 것이 먼저 나오는 방식
 */