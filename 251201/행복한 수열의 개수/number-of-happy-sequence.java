import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int ans = 0;

        for(int i = 0; i < n; i++){
            int cnt = 1;
            int max = 1;
            for(int j = 1; j < n; j++){
                if(grid[i][j - 1] == grid[i][j]){
                    cnt++;
                }else{
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
            if(max >= m){
                ans++;
            }
        }
        for(int i = 0; i < n; i++){
            int cnt = 1;
            int max = 1;
            for(int j = 1; j < n; j++){
                if(grid[j - 1][i] == grid[j][i]){
                    cnt++;
                }else{
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
            if(max >= m){
                ans++;
            }
        }
        System.out.println(ans);
    }
}