import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] planet, orderPlant;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        planet = new int[M][N];
        orderPlant = new int[M][N];
        ArrayList<Integer>[] sortedPlanets = new ArrayList[M];

        for (int i = 0; i < M; i++) {
            Set<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                planet[i][j] = Integer.parseInt(st.nextToken());
                set.add(planet[i][j]);
            }
            ArrayList<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            sortedPlanets[i] = list;
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                planet[i][j] = Collections.binarySearch(sortedPlanets[i], planet[i][j]);
            }
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                if (Arrays.equals(planet[i], planet[j])) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}