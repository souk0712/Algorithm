import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Rank[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        rank = new Rank[N + 1];
        rank[0] = new Rank("", -1);

        for (int n = 1; n <= N; n++) {
            String[] s = br.readLine().split(" ");
            rank[n] = new Rank(s[0], Integer.parseInt(s[1]));
        }
        StringBuilder sb = new StringBuilder();

        for (int m = 0; m < M; m++) {
            sb.append(rank[giveName(Integer.parseInt(br.readLine()))].title).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int giveName(int value) {
        int left = 0;
        int right = rank.length - 1;
        int mid = right;
        while (right - left > 1) {
            mid = (left + right) / 2;
            if (rank[mid].score >= value) right = mid;
            else left = mid;
        }
        if (rank[left].score == rank[right].score) return left;
        return right;
    }

    static class Rank implements Comparable<Rank> {
        String title;
        int score;

        Rank(String title, int score) {
            this.title = title;
            this.score = score;
        }

        @Override
        public int compareTo(Rank o) {
            return Integer.compare(score, o.score);
        }

        @Override
        public String toString() {
            return "title : " + title + ", score : " + score;
        }
    }
}