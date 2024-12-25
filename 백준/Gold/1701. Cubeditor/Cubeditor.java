import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int max;
    static int[] pi;
    static String input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        ArrayList<String> parString = getPartString();
        for (String s : parString) {
            getPi(s);
        }
        System.out.println(max);
    }

    private static ArrayList<String> getPartString() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            list.add(input.substring(i));
        }
        return list;
    }

    static void getPi(String pattern) {
        int j = 0;
        pi = new int[pattern.length()];
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
                max = Math.max(max, pi[i]);
            }
        }
    }
}