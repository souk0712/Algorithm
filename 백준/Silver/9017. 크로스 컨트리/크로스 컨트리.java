import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Map<Integer, ArrayList<Integer>> teams;  // 팀 별 rank list
    static Player[] players;    // 전체 rank
    static boolean[] active;    // 팀 활성화
    static int[] scores, count;        // 팀별 점수, 팀별 상위 4

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            teams = new HashMap<>();
            active = new boolean[201];
            players = new Player[N + 1];
            scores = new int[201];
            count = new int[201];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int team = Integer.parseInt(st.nextToken());
                players[i + 1] = new Player(i + 1, team);
                ArrayList<Integer> mt;
                if (!teams.containsKey(team)) {
                    mt = new ArrayList<>();
                } else {
                    mt = teams.get(team);
                }
                mt.add(i + 1);
                teams.put(team, mt);
            }

            for (int i = 0; i < teams.size(); i++) {
                ArrayList<Integer> list = teams.get(i + 1);
                if (list.size() < 6) {
                    active[i + 1] = true;
                }
            }

            for (int i = 1, score = 1; i < players.length; i++) {
                Player p = players[i];
                if (!active[p.team] ) {
                    if(count[p.team] < 4){
                        scores[p.team] += score++;
                        count[p.team]++;
                    }else{
                        score++;
                    }
                }
            }

            int minScore = Integer.MAX_VALUE;
            int ans = 0;
            for (int i = 1; i < scores.length; i++) {
                if (scores[i] != 0 && minScore > scores[i]) {
                    minScore = scores[i];
                    ans = i;
                }
            }

            ArrayList<Integer> minTeam = new ArrayList<>();
            for (int i = 1; i < scores.length; i++) {
                if (minScore == scores[i]) {
                    minTeam.add(i);
                }
            }

            if (minTeam.size() > 1) {
                minScore = Integer.MAX_VALUE;
                for (int i = 0; i < minTeam.size(); i++) {
                    int team = minTeam.get(i);
                    int score = teams.get(team).get(4);
                    if (minScore > score) {
                        minScore = score;
                        ans = team;
                    }
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    public static class Player {
        int idx, team;

        public Player(int idx, int team) {
            this.idx = idx;
            this.team = team;
        }
    }
}