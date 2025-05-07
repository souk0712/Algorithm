import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int r, c, k, rl, cl;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int time = 0;
        map = new int[101][101];
        rl = 3;
        cl = 3;
        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (map[r][c] != k) {
            if (time > 100) {
                time = -1;
                break;
            }
            if (rl >= cl) {
                rCalculate();
            } else {
                cCalculate();
            }
            time++;
        }
        System.out.println(time);
    }

    static void rCalculate() {
        // R 연산: 배열 A의 모든 행에 대해서 정렬을 수행
        // 행의 개수 ≥ 열의 개수인 경우에 적용
        int[][] newMap = new int[101][101];
        int newCL = 0;
        out:
        for (int i = 1; i <= rl; i++) {
            int[] arr = new int[101];
            for (int j = 1; j <= cl; j++) {
                if (i > 100 || j > 100) break out;
                if (map[i][j] == 0) continue;
                arr[map[i][j]]++;
            }
            PriorityQueue<Number> pq = new PriorityQueue<>();
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == 0) continue;
                pq.offer(new Number(j, arr[j]));
            }
            int length = 0;
            while (!pq.isEmpty()) {
                Number cur = pq.poll();
                newMap[i][++length] = cur.num;
                newMap[i][++length] = cur.count;
            }
            newCL = Math.max(length, newCL);
        }
        map = newMap;
        cl = newCL;
    }

    static void cCalculate() {
        // C 연산: 배열 A의 모든 열에 대해서 정렬을 수행
        // 행의 개수 < 열의 개수인 경우에 적용
        int[][] newMap = new int[101][101];
        int newRL = 0;
        out:
        for (int j = 1; j <= cl; j++) {
            int[] arr = new int[101];
            for (int i = 1; i <= rl; i++) {
                if (i > 100 || j > 100) break out;
                if (map[i][j] == 0) continue;
                arr[map[i][j]]++;
            }
            PriorityQueue<Number> pq = new PriorityQueue<>();
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 0) continue;
                pq.offer(new Number(i, arr[i]));
            }
            int length = 0;

            while (!pq.isEmpty()) {
                Number cur = pq.poll();
                newMap[++length][j] = cur.num;
                newMap[++length][j] = cur.count;
            }
            newRL = Math.max(length, newRL);
        }
        map = newMap;
        rl = newRL;
    }

    static class Number implements Comparable<Number> {
        int num;
        int count;

        Number(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public int compareTo(Number o) {
            int c = Integer.compare(count, o.count);
            if (c == 0) {
                return Integer.compare(num, o.num);
            } else {
                return c;
            }
        }
    }
}