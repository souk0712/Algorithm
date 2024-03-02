import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        double total = 0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            total += score;
            switch (grade) {
                case "A+":
                    sum += (4.5 * score);
                    break;
                case "A0":
                    sum += (4.0 * score);
                    break;
                case "B+":
                    sum += (3.5 * score);
                    break;
                case "B0":
                    sum += (3.0 * score);
                    break;
                case "C+":
                    sum += (2.5 * score);
                    break;
                case "C0":
                    sum += (2.0 * score);
                    break;
                case "D+":
                    sum += (1.5 * score);
                    break;
                case "D0":
                    sum += (score);
                    break;
                case "P":
                    total -= score;
            }
        }
        System.out.printf("%.6f", total == 0 ? 0 : sum / total);
    }
}
