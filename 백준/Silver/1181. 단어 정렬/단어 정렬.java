import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Set<String> input = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            input.add(br.readLine());
        }

        ArrayList<String> arr = new ArrayList<>(input);

        arr.sort((o1, o2) -> {
            int L1 = o1.length();
            int L2 = o2.length();

            if (L1 == L2)
                return o1.compareTo(o2);
            else
                return Integer.compare(L1, L2);
        });
        
        for (String s : arr) {
            sb.append(s).append("\n");
        }
        
        System.out.println(sb);
    }
}