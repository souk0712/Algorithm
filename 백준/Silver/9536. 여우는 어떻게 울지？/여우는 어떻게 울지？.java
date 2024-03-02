import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<String> words = new ArrayList<>();
            while (st.hasMoreTokens()) {
                words.add(st.nextToken());
            }
            boolean[] visit = new boolean[words.size()];
            String question = "";
            while (!question.equals("what does the fox say?")) {
                question = br.readLine();
                st = new StringTokenizer(question);
                String name = st.nextToken();
                String goes = st.nextToken();
                String sound = st.nextToken();
                for (int i = 0; i < words.size(); i++) {
                    if (words.get(i).equals(sound)) {
                        visit[i] = true;
                    }
                }
            }
            for (int i = 0; i < words.size(); i++) {
                if (!visit[i]) {
                    sb.append(words.get(i)).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}