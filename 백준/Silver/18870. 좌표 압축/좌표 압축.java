import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            set.add(x[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = Collections.binarySearch(list, x[i]);
            sb.append(index).append(" ");
        }
        System.out.println(sb);
    }
}