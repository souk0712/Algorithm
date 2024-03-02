package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String in = br.readLine();
            if (in==null) break;
            int t = Integer.parseInt(in);
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < 8; i++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            loop:
            while (true) {
                for (int i = 1; i < 6; i++) {
                    int tmp = queue.poll();
                    tmp -= i;
                    if (tmp < 0) tmp = 0;
                    queue.offer(tmp);
                    if (tmp == 0) break loop;
                }
            }
            System.out.print("#" + t + " ");
            for (int i = 0; i < 8; i++) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }
    }
}

/**
 * EOF는 End of File의 약자로, 데이터 소스로부터 더 이상 읽을 수 있는 데이터가 없음을 나타내는 용어입니다.

 * Scanner -> 입력된 토큰이 있으면 true를 반환, 그렇지 않을 경우 false를 반환
      Scanner scan = new Scanner(System.in);

      while(scan.hasNext()) {
        System.out.println(scan.nextLine());
      }

 * BufferedReader -> 입력값을 계속 읽되, 읽은 값이 null이 되면 반복문을 종료하는 방식
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String input = "";

      while((input = br.readLine()) != null) {
        // 이후 로직 전개.
      }
 */