import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        boolean[][] visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(n, m, grid, visit, i, j, 1, grid[i][j]);
                visit[i][j] = false;
            }
        }
        System.out.println(max);
    }

    static void dfs(int n, int m, int[][] grid, boolean[][] visit, int x, int y, int cnt, int sum){
        if(cnt == 3){
            max = Math.max(max, sum);
            return;
        }
        
        for(int k = 0; k < dx.length; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(visit[nx][ny]) continue;
            visit[nx][ny] = true;
            dfs(n, m, grid, visit, nx, ny, cnt + 1, sum + grid[nx][ny]);
            visit[nx][ny] = false;
        }
    }
}