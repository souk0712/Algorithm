import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (x == 0 && y == 0 && z == 0) {
                break;
            }
            if (x * x == y * y + z * z) {
                System.out.println("right");
            } else if (y * y == x * x + z * z) {
                System.out.println("right");
            } else if (z * z == x * x + y * y) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

        }
    }
}

/**
 * 입력
 * Scanner scanner = new Scanner(System.in);
       ->Scanner로 Standard Input Stream을 전달하여, 키보드에서 입력을 받을 수 있는 Scanner 객체를 하나 생성
 * scanner.nextLine();
       ->입력 받은 데이터 한 줄을 읽어서, String으로 리턴합니다.
 * scanner.nextInt();
 * scanner.nextFloat();
 * scanner.nextBoolean();
       ->Scanner의 nextXXX() 메소드를 이용하여 사용자로부터 입력받은 토큰(token)을 String, int, boolean 등의 타입으로 변환할 수 있습니다.
        (여기에서 token은 공백 문자 ('\t', '\f', '\r', ' ', '\n')를 말합니다.)
 *
 *
 * 문자열 쪼개기
 * StringTokenizer는 빈 문자열을 토큰으로 인식하지 않고, 결과값이 문자열이다.
 * Split는 빈 문자열을 토큰으로 인식하고, 결과 값이 문자열 배열이다.
 * StringTokonizer st = new StringTokenizer(문자열);
       ->" \t\n\r\t" 기준으로 문자열 분리.
 * StringTokonizer st = new StringTokenizer(문자열, 구분자);
       ->구분자를 기준으로 문자열을 분리
 * StringTokonizer st = new StringTokenizer(문자열, 구분자, true/false);
       ->구분자를 기준으로 문자열을 분리할 때 구분자도 토큰으로 넣을지(true) 구분자는 분리된 문자열 토큰에 포함 안시킬지(false=디폴트)
 */
