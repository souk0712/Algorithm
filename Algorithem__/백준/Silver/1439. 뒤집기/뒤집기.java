import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String init = br.readLine();
        int countZero = 0;
        int countOne = 0;
        char com = init.charAt(0);
        if (com == '0') {
            countZero++;
        } else if (com == '1') {
            countOne++;
        }
        for (int i = 0; i < init.length(); i++) {
            char c = init.charAt(i);
            if (com != c) {
                if (c == '0') {
                    countZero++;
                } else if (c == '1') {
                    countOne++;
                }
                com = c;
            }
        }

        System.out.println(Math.min(countOne, countZero));
    }
}