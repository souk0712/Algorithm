import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class JO1880_암호풀기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Character, Character> key = new HashMap<>();
		String inputKey = br.readLine();
		
		char[] inputKeyS = inputKey.toCharArray();
		char[] inputKeyB = inputKey.toUpperCase().toCharArray();
		char[] sentences = br.readLine().toCharArray();

		for (int i = 0; i < inputKeyS.length; i++) {
			key.put((char) ('a' + i),inputKeyS[i]);
			key.put((char) ('A' + i), inputKeyB[i]);
		}

		for (int i = 0; i < sentences.length; i++) {
			if (sentences[i] == ' ') {
				sb.append(' ');
			} else {
				sb.append(key.get(sentences[i]));
			}
		}
		System.out.println(sb);

	}

}
