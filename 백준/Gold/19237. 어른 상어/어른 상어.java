import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static int N, M, K;
    static int[][] map;
    static int[][][] priority;
    static Smell[][] smells;
    static Map<Integer, Shark> sharks;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        priority = new int[M + 1][5][4];
        sharks = new TreeMap<>();
        smells = new Smell[N][N];
        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    sharks.put(map[i][j], new Shark(map[i][j], i, j));
                    smells[i][j] = new Smell(map[i][j], K);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            Shark s = sharks.get(i);
            s.dir = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    priority[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int time = 0;
        while (!checkOneShark()) {
            // 상어 동시 이동
            moveSharks();
            // 상어 경로 냄새 지수 감소
            decreaseSmell();
            // 냄새 뿌리기
            spreadSmell();
            time++;
            if (time > 1000) {
                time = -1;
                break;
            }
        }
        System.out.println(time);
    }

    private static void spreadSmell() {
        for (Shark s : sharks.values()) {
            smells[s.x][s.y] = new Smell(s.id, K);
        }
    }

    private static void decreaseSmell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Smell s = smells[i][j];
                if (s == null) continue;
                int next = s.cnt - 1;
                if (next <= 0) {
                    smells[i][j] = null;
                } else {
                    s.cnt = next;
                }
            }
        }
    }

    private static void moveSharks() {
        ArrayList<Integer> removes = new ArrayList<>();
        loop:
        for (Shark s : sharks.values()) {
            map[s.x][s.y] = 0;
            for (int k = 0; k < 4; k++) {
                int dir = priority[s.id][s.dir][k];
                int nx = s.x + dx[dir];
                int ny = s.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                Smell smell = smells[nx][ny];
                if (smell != null) continue;
                if (map[nx][ny] != 0 && map[nx][ny] < s.id) {
                    removes.add(s.id);
                    continue loop;
                }
                // 빈 칸
                map[nx][ny] = s.id;
                s.x = nx;
                s.y = ny;
                s.dir = dir;
                continue loop;
            }

            for (int k = 0; k < 4; k++) {
                int dir = priority[s.id][s.dir][k];
                int nx = s.x + dx[dir];
                int ny = s.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                Smell smell = smells[nx][ny];
                // 빈 칸 없음 -> 내 냄새 칸으로 이동
                if (smell != null && smell.id != s.id) continue;
                map[nx][ny] = s.id;
                s.x = nx;
                s.y = ny;
                s.dir = dir;
                break;
            }
        }
        for (int id : removes) {
            sharks.remove(id);
        }
    }

    private static boolean checkOneShark() {
        if (sharks.size() != 1) return false;
        for (int id : sharks.keySet()) {
            if (id == 1) return true;
        }
        return false;
    }

    static class Shark implements Comparable<Shark> {
        int id, x, y, dir;

        Shark(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Shark o) {
            return Integer.compare(id, o.id);
        }

        @Override
        public String toString() {
            return "id: " + id + ", x: " + x + ", y: " + y + ", dir: " + dir;
        }
    }

    static class Smell {
        int id, cnt;

        Smell(int id, int cnt) {
            this.id = id;
            this.cnt = cnt;
        }
    }
}