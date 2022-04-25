package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java17478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int count = 0;
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        String front = "";
        outPut(input, count, front);
    }

    static void outPut(Integer n, Integer count, String front) {
        StringBuilder frontBuilder = new StringBuilder(front);
        if (count < n) {
            System.out.println(front + "\"재귀함수가 뭔가요?\"\n" +
                    front + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                    front + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                    front + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
            count++;
            frontBuilder.append("____");
            front = frontBuilder.toString();
            outPut(n, count, front);
            frontBuilder.delete(0,4);
            front = frontBuilder.toString();
            System.out.println(front + "라고 답변하였지.");
        } else {
            System.out.println(front + "\"재귀함수가 뭔가요?\"\n" +
                    front + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n" +
                    front + "라고 답변하였지."
            );
        }
    }
}
/**
 * StringBuilder sb = new StringBuilder();
 * sb.append(값)
 * - StringBuffer, StringBuilder 뒤에 값을 붙인다
 * sb.insert(인덱스, 값)
 * - 특정 인덱스부터 값을 삽입한다
 * sb.delete(인덱스, 인덱스)
 * - 특정 인덱스부터 인덱스까지 값을 삭제한다
 * sb.indexOf(값)
 * - 값이 어느 인덱스에 들어있는지 확인한다
 * sb.substring(인덱스, 인덱스)
 * - 인덱스부터 인덱스까지 값을 잘라온다
 * sb.length()
 * - 길이 확인
 * sb.replace(인덱스, 인덱스, 값)
 * - 인덱스부터 인덱스까지 값으로 변경
 * sb.reverse()
 * - 글자 순서를 뒤집는다
 */
