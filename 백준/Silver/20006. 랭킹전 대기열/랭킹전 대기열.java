import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int P, M;
    static Map<Integer, ArrayList<Player>> map;
    static ArrayList<Player> inputs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        P = Integer.parseInt(st.nextToken());   // 플레이어의 수
        M = Integer.parseInt(st.nextToken());    // 방의 정원
        map = new HashMap<>();
        inputs = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());   // 플레이어의 레벨
            String n = st.nextToken();                  // 닉네임
            inputs.add(new Player(l, n));
        }

        for (int i = 0; i < inputs.size(); i++) {
            RoomAssignments(0, inputs.get(i));
        }

        for (int i = 0; i < map.size(); i++) {
            ArrayList<Player> l = map.get(i);
            Collections.sort(l);

            if (l.size() == M) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }

            for (int j = 0; j < l.size(); j++) {
                Player pp = l.get(j);
                sb.append(pp.level).append(" ").append(pp.name).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void RoomAssignments(int room, Player p) {
        Player standard;
        ArrayList<Player> list;

        if (map.containsKey(room)) {
            list = map.get(room);
            standard = list.get(0);
        } else {
            list = new ArrayList<>();
            standard = p;
        }

        if (p.level <= standard.level + 10 && p.level >= standard.level - 10 && list.size() < M) {
            list.add(p);
            map.put(room, list);
        } else {
            RoomAssignments(room + 1, p);
        }
    }

    public static class Player implements Comparable<Player> {
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player o) {
            return name.compareTo(o.name);
        }
    }
}