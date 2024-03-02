import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S;
    static StringBuilder T;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = new StringBuilder(br.readLine());
        dfs(T);

        System.out.println(check ? 1 : 0);
    }

    // 문자열의 뒤에 A를 추가한다. -> 문자열의 뒤가 A면 A를 제외
    // 문자열의 뒤에 B를 추가하고 문자열을 뒤집는다. -> 문자열의 앞이 B이면 B를 제외하고, 문자열을 뒤집는다.
    private static void dfs(StringBuilder str) {
        if (check || str.length() == S.length()) {
            if (str.toString().equals(S)) check = true;
            return;
        }

        char front = str.charAt(0);
        char last = str.charAt(str.length() - 1);

        // 문자열의 뒤가 A면 A를 제외
        if (last == 'A') {
            str.deleteCharAt(str.length() - 1);
            dfs(str);
            str.append('A');
        }
        // 문자열의 앞이 B이면 B를 제외하고, 문자열을 뒤집는다.
        if (front == 'B') {
            str.deleteCharAt(0);
            str.reverse();
            dfs(str);
            str.reverse();
            str.insert(0,'B');
        }
    }
}