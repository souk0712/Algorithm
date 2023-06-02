import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        Set<String> set = new HashSet<>();

        // Y(2), F(3), O(4)
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int res = 0;

        if ("Y".equals(input[1])) {
            res = set.size();
        } else if ("F".equals(input[1])) {
            res = set.size() / 2;
        } else if ("O".equals(input[1])) {
            res = set.size() / 3;
        }

        System.out.println(res);
    }
}