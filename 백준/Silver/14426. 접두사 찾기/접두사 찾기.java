import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            trie.insert(input);
        }

        for (int j = 0; j < M; j++) {
            String checkWord = br.readLine();
            if (trie.hasWord(checkWord)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static class Node {
        Map<Character, Node> childNode = new HashMap<>();
        boolean endOfWord;
    }

    static class Trie {
        Node rootNode = new Node();

        void insert(String str) {
            Node node = this.rootNode;

            for (int i = 0; i < str.length(); i++) {
                node = node.childNode.computeIfAbsent(str.charAt(i), key -> new Node());
            }

            node.endOfWord = true;
        }

        boolean hasWord(String str) {
            Node node = this.rootNode;

            for (int i = 0; i < str.length(); i++) {
                node = node.childNode.getOrDefault(str.charAt(i), null);
                if (node == null) {
                    return false;
                }
            }
            return true;
        }
    }
}