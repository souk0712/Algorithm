import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] sentences = br.readLine().split(" ");

            int answer = 1;

            for (int k = 0; k < sentences.length; k++) {
                int count = 0;

                for (int j = 0; j < words.length; j++) {

                    char first = words[j].charAt(0);
                    char end = words[j].charAt(words[j].length() - 1);

                    // 앞, 뒤 단어가 같다
                    if (words[j].length() == sentences[k].length() && first == sentences[k].charAt(0) && end == sentences[k].charAt(sentences[k].length() - 1)) {

                        if (sentences[k].length() > 1 && words[j].length() > 1) {

                            // 중간 단어가 구성요소가 다른지 확인
                            char[] str = words[j].substring(1, words[j].length() - 1).toCharArray();
                            Arrays.sort(str);

                            char[] target = sentences[k].substring(1, sentences[k].length() - 1).toCharArray();
                            Arrays.sort(target);

                            if (Arrays.equals(str, target)) {
                                count++;
                            }
                        } else {
                            count++;
                        }
                    }
                }
                answer = (count == 0 ? 0 : answer) * count;
            }

            System.out.println(answer);
        }
    }
}