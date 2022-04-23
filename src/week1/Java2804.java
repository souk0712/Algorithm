package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java2804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split(" ");
        String[] A = word[0].split("");
        String[] B = word[1].split("");
        int row = 0;
        int column = 0;

        loop:
        for (int n = 0; n < A.length; n++) {
            for (int m = 0; m < B.length; m++) {
                if (A[n].equals(B[m])) {
                    row = m;
                    column = n;
                    break loop;
                }
            }
        }

        for (int m = 0; m < B.length; m++) {
            for (int n = 0; n < A.length; n++) {
                if (row == m) {
                    System.out.print(A[n]);
                } else if (column == n)
                    System.out.print(B[m]);
                else
                    System.out.print(".");
            }
            System.out.println();
        }
    }
}
/**
 * 이중 for 문 나가는 법.
 * for 문에 이름을 붙여서 지정한 이름으로 이동.
 * 이름:
 *      break 이름;
 *
 * StringBuilder는 String 과 문자열을 더할 때 새로운 객체를 생성하는 것이 아니라
 * 기존의 데이터에 더하는 방식을 사용하기 때문에 속도도 빠르며 상대적으로 부하가 적다.
 * StringBuilder sb = new StringBuilder();
 * sb.append("ABC");
 * sb.append("DEF");
 * System.out.println(sb.toString());
 */