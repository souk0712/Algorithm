import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<String> list = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.length() >= M) {
                list.add(input);

                if (count.containsKey(input)) {
                    int c = count.get(input);
                    count.put(input, c += 1);
                } else {
                    count.put(input, 1);
                }
            }
        }

        Collections.sort(list, (o1, o2) -> {
            int o1Count = count.get(o1);
            int o2Count = count.get(o2);
            int i = Integer.compare(o2Count, o1Count);
            if (i == 0) {
                int ii = Integer.compare(o2.length(), o1.length());
                if (ii == 0) {
                    return o1.compareTo(o2);
                } else {
                    return ii;
                }
            } else {
                return i;
            }
        });

        String com = "";
        for (int i = list.size() - 1; i >= 0; i--) {
            if (com.equals(list.get(i))) {
                list.remove(i);
            } else {
                com = list.get(i);
            }
        }

        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}